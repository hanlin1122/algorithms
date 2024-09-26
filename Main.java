class Main {
  public static int[] collate3(int[] a, int[] b, int[] c){
    int[] collatedArray = new int[3*a.length];
    int temp = 0;

    if(a == null && b == null && c == null){
      return null;
    }
    for(int i = 0; i < a.length; i++){
      collatedArray[temp] = a[i];
      temp++;
      collatedArray[temp] = b[i];
      temp++;
      collatedArray[temp] = c[i];
      temp++;
    }
    
    return collatedArray;
  }
  
  public static int[] collate2(int[] a, int[] b){
    if (a == null && b != null) {
      return b;
    }
    else if (b == null && a != null) {
      return a;
    }
    else if (b == null && a == null) {
      return b;
    }

    int length = Math.max(a.length, b.length);
    int[] collatedArray = new int[a.length + b.length];
    int e = 0;
    
    for (int i = 0; i < length; i++) {
      if (i < a.length) {
        collatedArray[e] = a[i];
        e++;
      }
      if (i < b.length) {
        collatedArray[e] = b[i];
        e++;
      }
    }

    return collatedArray;
  }
  
  public static int[] merge(int[] a, int[] b) {
    if (a == null) {
      return b;
    }
    else if (b == null) {
      return a;
    }
    int[] p = new int[a.length + b.length];
    int i = 0;
    int t = 0;
    int f = 0;
    while (i <= a.length && t <= b.length) {
      if (a[i] < b[t]) {
        p[f] = a[i];
        f++;
        i++;
      }
      else if (b[t] <= a[i]) {
        p[f] = b[t];
        t++;
        f++;
      }
      if (i >= a.length) {
        for (int x = t; x < b.length; x++) {
          p[f] = b[t];
          f++;
          t++;
        }
        break;
      }
      else if (t >= b.length) {
        for (int x = i; x < a.length; x++) {
          p[f] = a[i];
          f++;
          i++;
        }
        break;
      }
    }
    return p;    
  }
  
  public static int smallestIndex1(int[] a) {
    int ans = 0;
    int t = Integer.MAX_VALUE;
    for (int x = 0; x < a.length; x++) {
      if (a[x] < t) {
        ans = x;
        t = a[x];
      }
    }

    return ans;
  }
  
  public static int smallestIndex(int[] a, int p) {
    int t = Integer.MAX_VALUE;
    int ans = 0;
    for (int x = p; x < a.length; x++) {
      if (a[x] < t) {
        ans = x;
        t = a[x];
      }
    }

    return ans;
  }
 
  public static void sSort(int[] a) {
    for (int x = 0; x < a.length; x++) {
      int ans = 0;
      int t = smallestIndex(a, x);
      int temp = a[x];
      a[x] = a[t];
      a[t] = temp;
    }
  }
  
  public static void selectionSort(int[] a) {
    for (int x = 0; x < a.length; x++) {
      int max = a[x];
      int ans = 0;
      for (int i = x; i < a.length; i++) {
        if (a[i] <= max) {
          max = a[i];
          ans = i;
        }
      }
      int temp = a[x];
      a[x] = a[ans];
      a[ans] = temp;
    }

  }
  
  public static void main(String[] args) {
    
  }
}
