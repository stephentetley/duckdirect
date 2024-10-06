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

public enum ValueType {
    DUCKDB_TYPE_INVALID,
    DUCKDB_TYPE_BOOLEAN,
    DUCKDB_TYPE_TINYINT,
    DUCKDB_TYPE_SMALLINT,
    DUCKDB_TYPE_INTEGER,
    DUCKDB_TYPE_BIGINT,
    DUCKDB_TYPE_UTINYINT,
    DUCKDB_TYPE_USMALLINT,
    DUCKDB_TYPE_UINTEGER,
    DUCKDB_TYPE_UBIGINT,
    DUCKDB_TYPE_FLOAT,
    DUCKDB_TYPE_DOUBLE,
    DUCKDB_TYPE_TIMESTAMP,
    DUCKDB_TYPE_DATE,
    DUCKDB_TYPE_TIME,
    DUCKDB_TYPE_INTERVAL,
    DUCKDB_TYPE_HUGEINT,
    DUCKDB_TYPE_UHUGEINT,
    DUCKDB_TYPE_VARCHAR,
    DUCKDB_TYPE_BLOB,
    DUCKDB_TYPE_DECIMAL,
    DUCKDB_TYPE_TIMESTAMP_S,
    DUCKDB_TYPE_TIMESTAMP_MS,
    DUCKDB_TYPE_TIMESTAMP_NS,
    DUCKDB_TYPE_ENUM,
    DUCKDB_TYPE_LIST,
    DUCKDB_TYPE_STRUCT,
    DUCKDB_TYPE_MAP,
    DUCKDB_TYPE_ARRAY,
    DUCKDB_TYPE_UUID,
    DUCKDB_TYPE_UNION,
    DUCKDB_TYPE_BIT,
    DUCKDB_TYPE_TIME_TZ,
    DUCKDB_TYPE_TIMESTAMP_TZ,
    DUCKDB_TYPE_ANY,
    DUCKDB_TYPE_VARINT,
    DUCKDB_TYPE_SQLNULL;

    public static ValueType of(int i) throws Exception {
        switch (i) {
            case 0: return DUCKDB_TYPE_INVALID;
            case 1: return DUCKDB_TYPE_BOOLEAN;
            case 2: return DUCKDB_TYPE_TINYINT;
            case 3: return DUCKDB_TYPE_SMALLINT;
            case 4: return DUCKDB_TYPE_INTEGER;
            case 5: return DUCKDB_TYPE_BIGINT;
            case 6: return DUCKDB_TYPE_UTINYINT;
            case 7: return DUCKDB_TYPE_USMALLINT;
            case 8: return DUCKDB_TYPE_UINTEGER;
            case 9: return DUCKDB_TYPE_UBIGINT;
            case 10: return DUCKDB_TYPE_FLOAT;
            case 11: return DUCKDB_TYPE_DOUBLE;
            case 12: return DUCKDB_TYPE_TIMESTAMP;
            case 13: return DUCKDB_TYPE_DATE;
            case 14: return DUCKDB_TYPE_TIME;
            case 15: return DUCKDB_TYPE_INTERVAL;
            case 16: return DUCKDB_TYPE_HUGEINT;
            case 17: return DUCKDB_TYPE_UHUGEINT;
            case 18: return DUCKDB_TYPE_VARCHAR;
            case 19: return DUCKDB_TYPE_BLOB;
            case 20: return DUCKDB_TYPE_DECIMAL;
            case 21: return DUCKDB_TYPE_TIMESTAMP_S;
            case 22: return DUCKDB_TYPE_TIMESTAMP_MS;
            case 23: return DUCKDB_TYPE_TIMESTAMP_NS;
            case 24: return DUCKDB_TYPE_ENUM;
            case 25: return DUCKDB_TYPE_LIST;
            case 26: return DUCKDB_TYPE_STRUCT;
            case 27: return DUCKDB_TYPE_MAP;
            case 28: return DUCKDB_TYPE_ARRAY;
            case 29: return DUCKDB_TYPE_UUID;
            case 30: return DUCKDB_TYPE_UNION;
            case 31: return DUCKDB_TYPE_BIT;
            case 32: return DUCKDB_TYPE_TIME_TZ;
            case 33: return DUCKDB_TYPE_TIMESTAMP_TZ;
            case 34: return DUCKDB_TYPE_ANY;
            case 35: return DUCKDB_TYPE_VARINT;
            case 36: return DUCKDB_TYPE_SQLNULL;
            default: throw new RuntimeException("Invalid ValueType enum: " + i);
        }
    }
}
