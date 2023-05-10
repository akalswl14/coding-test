class Solution {

  private int[][] arr;
  private final int[] rtn = new int[]{0, 0};

  public int[] solution(int[][] arr) {
    this.arr = arr;

    recursion(0, arr.length, 0, arr.length);
    return rtn;
  }

  private void recursion(int r1, int r2, int c1, int c2) {
    if (allSame(r1, r2, c1, c2)) {
      rtn[arr[r1][c1]]++;
    } else {
      int mid = (r2-r1+1)/2;
      recursion(r1, r1+mid, c1, c1+mid);
      recursion(r1, r1+mid, c1+mid, c2);
      recursion(r1+mid, r2, c1, c1+mid);
      recursion(r1+mid, r2, c1+mid, c2);
    }
  }

  private boolean allSame(int r1, int r2, int c1, int c2) {
    int value = arr[r1][c1];

    for (int i = r1; i < r2; i++) {
      for (int j = c1; j < c2; j++) {
        int num = arr[i][j];
        if (value != num) {
          return false;
        }
      }
    }
    return true;
  }
}