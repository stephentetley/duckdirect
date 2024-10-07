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
import org.duckdirect.internal.DuckDBState;

public class Connection implements AutoCloseable {
    private Arena duckArena;
    private MemorySegment connectionpPtr;

    protected Connection(Arena arena, MemorySegment ptr) {
        this.duckArena = arena;
        this.connectionpPtr = ptr;
    }

    // Note some queries CREATE TABLE etc don't return return a Result
    public Result query(String query) throws Exception {
        MemorySegment conn = this.connectionpPtr.get(duckdb_h.C_POINTER, 0);
        MemorySegment res = duckdb_result.allocate(this.duckArena);
        // Is this the right way to get a pointer to the res?
        MemorySegment resPtr = duckdb_result.ofAddress(res, this.duckArena);
        int i = duckdb_h.duckdb_query(conn, this.duckArena.allocateUtf8String(query), resPtr);
        if (i == DuckDBState.DUCKDB_SUCCESS) {
            return new Result(this.duckArena, res, resPtr);
        } else {
            throw new RuntimeException("query");
        }
    }

    public void execute(String statement) throws Exception {
        MemorySegment conn = this.connectionpPtr.get(duckdb_h.C_POINTER, 0);
        MemorySegment res = duckdb_result.allocate(this.duckArena);
        MemorySegment resPtr = duckdb_result.ofAddress(res, this.duckArena);
        int i = duckdb_h.duckdb_query(conn, this.duckArena.allocateUtf8String(statement), resPtr);
        if (i == DuckDBState.DUCKDB_SUCCESS) {
            return;
        } else {
            throw new RuntimeException("execute");
        }
    }


    public void close() throws Exception {
        duckdb_h.duckdb_disconnect(this.connectionpPtr);
    }

}
