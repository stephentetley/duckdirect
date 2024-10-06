# duckdirect

Experiments calling the DuckDB C API (v1.1) via Java Panama

Currently on Java 21 (differences to 22 are allocate / get Utf8Strings).


`duckdb.dll` and `duckdb.lib` are included at the top level for Windows users. 
Linux / MacOS users will need to add relevant shared libraries to the project
root or install and use a DuckDB 1.1 library somewhere in the system path.

With IntelliJ set the language level to `X - Experimental features` and include 
the JExtract generated files in `lib` as a library root.

The JExtract files were generated from `duckdb.h` version 1.1 and given the 
namespace `org.duckdb.capi`.

MIT License