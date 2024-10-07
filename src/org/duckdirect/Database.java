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
import java.nio.file.Path;

import org.duckdb.capi.duckdb_h;
import org.duckdirect.internal.DuckDBState;


public class Database implements AutoCloseable {
    private Arena duckArena;
    private MemorySegment databasepPtr;

    private Database(Arena arena, MemorySegment ptr) {
        this.duckArena = arena;
        this.databasepPtr = ptr;
    }

    public static String getLibraryVersion() {
        MemorySegment ptr = duckdb_h.duckdb_library_version();
        return ptr.getUtf8String(0);
    }

    public static Database open(Path path) throws Exception {
        Arena arena = Arena.ofConfined();
        MemorySegment dbPtr = arena.allocate(duckdb_h.C_POINTER);
        String spath = null;
        if (path != null) {
            spath = path.toString();
        }
        int i = duckdb_h.duckdb_open(arena.allocateUtf8String(spath), dbPtr);
        if (i == DuckDBState.DUCKDB_SUCCESS) {
            return new Database(arena, dbPtr);
        } else {
            throw new RuntimeException("open");
        }
    }

    public void close() throws Exception {
        duckdb_h.duckdb_close(this.databasepPtr);
        duckArena.close();
    }

    public Connection connect() throws Exception {
        MemorySegment conn = this.duckArena.allocate(duckdb_h.C_POINTER);
        System.out.println("connect.1");
        MemorySegment db = this.databasepPtr.get(duckdb_h.C_POINTER, 0);
        int i = duckdb_h.duckdb_connect(db, conn);
        System.out.println("connect.2");
        if (i == DuckDBState.DUCKDB_SUCCESS) {
            System.out.println("connect.3");
            return new Connection(this.duckArena, conn);
        } else {
            throw new RuntimeException("connect");
        }
    }

    public void interrupt() throws Exception {
        duckdb_h.duckdb_interrupt(this.databasepPtr);
    }
}
