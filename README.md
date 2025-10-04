# Assignment 2 – Selection Sort Benchmark

## Project Overview
This project implements and benchmarks **Selection Sort** and an **optimized version**.  
Performance is measured in terms of:
- Comparisons
- Swaps
- Array accesses
- Execution time

Results are saved into `results.csv` and plotted in `docs/performance-plots/`.

## Project Structure
- `src/main/java/cli/BenchmarkRunner.java` – CLI entry point
- `src/main/java/sort/SelectionSort.java` – Baseline implementation
- `src/main/java/sort/SelectionSortOptimized.java` – Optimized version
- `src/test/java/...` – Unit tests
- `docs/performance-plots/` – Benchmark plots
- `pom.xml` – Maven build file

## How to Run
Compile and run benchmark runner:
```bash
mvn clean compile exec:java
