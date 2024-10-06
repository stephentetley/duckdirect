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


import org.duckdirect.Connection;
import org.duckdirect.Database;
import org.duckdirect.Result;

import java.nio.file.Path;

public class Demo1 {



    public static void main(String[] args) throws Exception {
        System.loadLibrary("duckdb");
        System.out.print("Running...");
        String s = Database.getLibraryVersion();
        System.out.println("version: " + s);

        try (Database db = Database.open(Path.of("data/db2.duckdb"))) {
            System.out.println("open success");
            try (Connection conn = db.connect()) {
                try(Result res = conn.query("SELECT * FROM duckdb_settings();")) {
                    // Getting a EXCEPTION_ACCESS_VIOLATION here...
                    System.out.println("result...");
                    System.out.println("Column count: " + res.columnCount());
                    System.out.println("Column 0: " + res.columnName(0));
                    System.out.println("Column 1: " + res.columnName(1));
                    System.out.println("Rows changed: " + res.rowsChanged());
                    System.out.println("result.1");
                }
                System.out.println("connection.1");
            }
        }
        System.out.println("Done");
    }

}
