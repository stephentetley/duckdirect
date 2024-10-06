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

public enum StatementType {
    DUCKDB_STATEMENT_TYPE_INVALID,
    DUCKDB_STATEMENT_TYPE_SELECT,
    DUCKDB_STATEMENT_TYPE_INSERT,
    DUCKDB_STATEMENT_TYPE_UPDATE,
    DUCKDB_STATEMENT_TYPE_EXPLAIN,
    DUCKDB_STATEMENT_TYPE_DELETE,
    DUCKDB_STATEMENT_TYPE_PREPARE,
    DUCKDB_STATEMENT_TYPE_CREATE,
    DUCKDB_STATEMENT_TYPE_EXECUTE,
    DUCKDB_STATEMENT_TYPE_ALTER,
    DUCKDB_STATEMENT_TYPE_TRANSACTION,
    DUCKDB_STATEMENT_TYPE_COPY,
    DUCKDB_STATEMENT_TYPE_ANALYZE,
    DUCKDB_STATEMENT_TYPE_VARIABLE_SET,
    DUCKDB_STATEMENT_TYPE_CREATE_FUNC,
    DUCKDB_STATEMENT_TYPE_DROP,
    DUCKDB_STATEMENT_TYPE_EXPORT,
    DUCKDB_STATEMENT_TYPE_PRAGMA,
    DUCKDB_STATEMENT_TYPE_VACUUM,
    DUCKDB_STATEMENT_TYPE_CALL,
    DUCKDB_STATEMENT_TYPE_SET,
    DUCKDB_STATEMENT_TYPE_LOAD,
    DUCKDB_STATEMENT_TYPE_RELATION,
    DUCKDB_STATEMENT_TYPE_EXTENSION,
    DUCKDB_STATEMENT_TYPE_LOGICAL_PLAN,
    DUCKDB_STATEMENT_TYPE_ATTACH,
    DUCKDB_STATEMENT_TYPE_DETACH,
    DUCKDB_STATEMENT_TYPE_MULTI;

    public static StatementType of(int i) throws Exception {
        switch (i) {
            case 0: return DUCKDB_STATEMENT_TYPE_INVALID;
            case 1: return DUCKDB_STATEMENT_TYPE_SELECT;
            case 2: return DUCKDB_STATEMENT_TYPE_INSERT;
            case 3: return DUCKDB_STATEMENT_TYPE_UPDATE;
            case 4: return DUCKDB_STATEMENT_TYPE_EXPLAIN;
            case 5: return DUCKDB_STATEMENT_TYPE_DELETE;
            case 6: return DUCKDB_STATEMENT_TYPE_PREPARE;
            case 7: return DUCKDB_STATEMENT_TYPE_CREATE;
            case 8: return DUCKDB_STATEMENT_TYPE_EXECUTE;
            case 9: return DUCKDB_STATEMENT_TYPE_ALTER;
            case 10: return DUCKDB_STATEMENT_TYPE_TRANSACTION;
            case 11: return DUCKDB_STATEMENT_TYPE_COPY;
            case 12: return DUCKDB_STATEMENT_TYPE_ANALYZE;
            case 13: return DUCKDB_STATEMENT_TYPE_VARIABLE_SET;
            case 14: return DUCKDB_STATEMENT_TYPE_CREATE_FUNC;
            case 15: return DUCKDB_STATEMENT_TYPE_DROP;
            case 16: return DUCKDB_STATEMENT_TYPE_EXPORT;
            case 17: return DUCKDB_STATEMENT_TYPE_PRAGMA;
            case 18: return DUCKDB_STATEMENT_TYPE_VACUUM;
            case 19: return DUCKDB_STATEMENT_TYPE_CALL;
            case 20: return DUCKDB_STATEMENT_TYPE_SET;
            case 21: return DUCKDB_STATEMENT_TYPE_LOAD;
            case 22: return DUCKDB_STATEMENT_TYPE_RELATION;
            case 23: return DUCKDB_STATEMENT_TYPE_EXTENSION;
            case 24: return DUCKDB_STATEMENT_TYPE_LOGICAL_PLAN;
            case 25: return DUCKDB_STATEMENT_TYPE_ATTACH;
            case 26: return DUCKDB_STATEMENT_TYPE_DETACH;
            case 27: return DUCKDB_STATEMENT_TYPE_MULTI;
            default: throw new RuntimeException("Invalid StatementType enum: " + i);
        }
    }
}