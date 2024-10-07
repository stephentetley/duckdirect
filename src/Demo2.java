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


import org.duckdirect.*;

import java.nio.file.Path;

public class Demo2 {

    public static void main(String[] args) throws Exception {
        System.loadLibrary("duckdb");
        System.out.print("Running...");
        String s = Database.getLibraryVersion();
        System.out.println("version: " + s);

        try (Database db = Database.open(Path.of("data/values.duckdb"))) {
            System.out.println("open success");
            try (Connection conn = db.connect()) {
                conn.execute("CREATE OR REPLACE TABLE integers (i INTEGER, j INTEGER);");
                conn.execute("INSERT INTO integers VALUES (3, 4), (5, 6), (7, NULL);");
                try(Result res = conn.query("SELECT * FROM integers;")) {
                    while (true) {
                        try (DataChunk chunk = res.fetchChunk()) {
                            System.out.println("chunk...");
                            System.out.println("Chunk column count: " + chunk.getColumnCount());
                            System.out.println("Chunk size: " + chunk.getSize());
//                            long rowCount = chunk.getSize();
//                            ValueVector col1 = chunk.getVector(0);
                        }
                        break;
                    }
                }
            }
        }
        System.out.println("Done");
    }

}
