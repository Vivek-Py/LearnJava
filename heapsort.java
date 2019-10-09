class heapsort{
public static void sort(int[] a)
{
    int N = a.length;
    for (int k = N/2; k >= 1; k--)
        sink(a, k, N);
    while (N > 1)
    {
        exch(a, 1, N--);
        sink(a, 1, N);
    }
}
private void sink(int pq[],int k)
{
    while (2*k <= N)
    {
        int j = 2*k;
        if (j < N && less(j, j+1)) j++;
        if (!less(pq[],k, j)) break;
        exch(pq[],k, j);
        k = j;
    }
}
private boolean less(int pq[],int i, int j)
{    return pq[i]<pq[j]; }
private void exch(int pq[],int i, int j)
{   int t = pq[i]; pq[i] = pq[j]; pq[j] = t; }
}