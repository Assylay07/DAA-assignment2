import pandas as pd
import matplotlib.pyplot as plt

df = pd.read_csv("../../results.csv")

for algo in df['algorithm'].unique():
    subset = df[df['algorithm'] == algo]
    plt.plot(subset['size'], subset['timeNs'], marker='o', label=algo)

plt.xlabel("Array Size")
plt.ylabel("Time (ns)")
plt.title("Sorting Performance (Time vs Size)")
plt.legend()
plt.grid(True)
plt.savefig("time_vs_size.png")
plt.clf()

for algo in df['algorithm'].unique():
    subset = df[df['algorithm'] == algo]
    plt.plot(subset['size'], subset['comparisons'], marker='o', label=algo)

plt.xlabel("Array Size")
plt.ylabel("Comparisons")
plt.title("Sorting Performance (Comparisons vs Size)")
plt.legend()
plt.grid(True)
plt.savefig("comparisons_vs_size.png")
plt.clf()

for algo in df['algorithm'].unique():
    subset = df[df['algorithm'] == algo]
    plt.plot(subset['size'], subset['arrayAccesses'], marker='o', label=algo)

plt.xlabel("Array Size")
plt.ylabel("Array Accesses")
plt.title("Sorting Performance (Array Accesses vs Size)")
plt.legend()
plt.grid(True)
plt.savefig("arrayAccesses_vs_size.png")
plt.clf()

print("Done")
