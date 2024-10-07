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

// Make this a tangible object - in C it is an array of long

public class ValidityMask {
    private Arena duckArena;
    private MemorySegment mask;

    protected ValidityMask(Arena arena, MemorySegment vec) {
        this.duckArena = arena;
        this.mask = vec;
    }

    public boolean rowIsValid(long row) {
        return duckdb_h.duckdb_validity_row_is_valid(this.mask, row);
    }

    public void setRowInvalid(long row) {
        duckdb_h.duckdb_validity_set_row_invalid(this.mask, row);
    }

    public void setRowValid(long row) {
        duckdb_h.duckdb_validity_set_row_valid(this.mask, row);
    }

    public void setRowValidity(long row, boolean valid) {
        duckdb_h.duckdb_validity_set_row_validity(this.mask, row, valid);
    }

}
