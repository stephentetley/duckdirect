// MIT License
//
// Copyright (c) 2024 Stephen Tetley
//
// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:
//
// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.
//
// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package org.duckdirect;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import org.duckdb.capi.duckdb_h;
import org.duckdb.capi.duckdb_result;

public class Result implements AutoCloseable {
    private Arena duckArena;
    /// Note duckdb's `result` type is a struct not a pointer to a struct...
    private MemorySegment result;
    private MemorySegment resultPtr;

    protected Result(Arena arena, MemorySegment res, MemorySegment ptr) {
        this.duckArena = arena;
        this.result = res;
        this.resultPtr = ptr;
    }


    public void close() throws Exception {
        duckdb_h.duckdb_destroy_result(this.resultPtr);
    }

    public String columnName(long ix) throws Exception {
        return duckdb_h.duckdb_column_name(this.resultPtr, ix).getUtf8String(0);
    }

    public ValueType columnType(long ix) throws Exception {
        return ValueType.of(duckdb_h.duckdb_column_type(this.resultPtr, ix));
    }

    public StatementType resultStatementType() throws Exception {
        return StatementType.of(duckdb_h.duckdb_result_statement_type(this.result));
    }


    public long columnCount() throws Exception {
        return duckdb_h.duckdb_column_count(this.resultPtr);
    }

    public long rowsChanged() throws Exception {
        return duckdb_h.duckdb_rows_changed(this.resultPtr);
    }

    public String resultError() throws Exception {
        return duckdb_h.duckdb_result_error(this.resultPtr).getUtf8String(0);
    }

    // The primitive C function `duckdb_fetch_chunk` returns NULL on error, this should be
    // transformed into an Exception by the JExtract code.
    public DataChunk fetchChunk() throws Exception {
        try {
            MemorySegment chunk = duckdb_h.duckdb_fetch_chunk(this.result);
            return new DataChunk(this.duckArena, chunk);
        } catch (Exception e) {
            System.out.println("fetchChunk - exception");
            return null;
        }

    }

}
