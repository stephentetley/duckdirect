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

import org.duckdb.capi.duckdb_h;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;

public class DataChunk implements AutoCloseable {
    private Arena duckArena;
    private MemorySegment dataChunk;

    protected DataChunk(Arena arena, MemorySegment chunk) {
        this.duckArena = arena;
        this.dataChunk = chunk;
    }

    public void close() throws Exception {
        System.out.println("DataChunk.close()");
        MemorySegment chunkPtr = this.dataChunk.get(duckdb_h.C_POINTER, 0);  // <-- this is wrong
        duckdb_h.duckdb_destroy_data_chunk(chunkPtr);
        System.out.println("DataChunk.close().2");
    }

    public long getColumnCount() throws Exception {
        return duckdb_h.duckdb_data_chunk_get_column_count(this.dataChunk);
    }

    public long getSize() throws Exception {
        return duckdb_h.duckdb_data_chunk_get_size(this.dataChunk);
    }
    public ValueVector getVector(long ix) throws Exception {
        MemorySegment vec = duckdb_h.duckdb_data_chunk_get_vector(this.dataChunk, ix);
        return new ValueVector(this.duckArena, vec);
    }
}
