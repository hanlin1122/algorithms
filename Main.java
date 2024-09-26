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
  public static void testCode1(){
    int[] a = {1,4,7};
    int[] b = {2,5,8};
    int[] c = {3,6,9};
    int[] ans = collate3(a, b, c);
    int[] correct = {1,2,3,4,5,6,7,8,9};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= ans[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 1 works!!!");
    else
      System.out.println("Part 1 back to the drawing board");
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
  
  public static void testCode2(){
    int[] a = {1,2,3};
    int[] b = {4};
    int[] ans = collate2(a, b);
    int[] correct = {1,4,2,3};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= ans[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 2 works!!!");
    else
      System.out.println("Part 2 back to the drawing board");
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
  
  public static void testCode3(){
    int[] a = {1,3,4,8}, b = {2,5,6,7,8};
  int ans[] = merge(a, b);
  int[] correct = {1, 2, 3, 4, 5, 6, 7, 8, 8};
    boolean allElementsMatch = true;
    for(int i=0; i<correct.length; i++)
      allElementsMatch &= ans[i] == correct[i];
    if(allElementsMatch)
      System.out.println("Part 3 works!!!");
    else
      System.out.println("Part 3 back to the drawing board");
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
  
  public static void testCode4a(){
    int[] a = {5, 4,1, 2, 3};
    int t = smallestIndex1(a);
    int correct = 2;
    if (t == correct) {
      System.out.println("Part 4 works!!!");
    }
    else {
      System.out.println("Wrong");
    }
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
  public static void testCode4c(){
    int[] a = {3, 4, 5, 6, 7, 3, 9};
    int t = smallestIndex(a, 4);
    int correct = 5;
    if (t == correct) {
      System.out.println("Part 4c works!!!");
    }
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

  public static void testCode5a(){
    int[] a = {1,3,4,8,5,7,6,2};
    sSort(a);
    int[] correct = {1, 2, 3, 4, 5, 6, 7, 8};
    Boolean checker = true;
    for (int x = 0; x < a.length; x++) {
      if (a[x] != correct[x]) {
        checker = false;
      }
    }
    if (checker) {
      System.out.println("Part 5a works!!!");
    }
    else {
      System.out.println("Wrong");
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

  public static void testCode5c(){
    // Test a = {1,3,4,8,5,7,6,2}
    int[] a = {1,3,4,8,5,7,6,2};
    selectionSort(a);
    int[] correct = {1, 2, 3, 4, 5, 6, 7, 8};
    Boolean checker = true;
    for (int x = 0; x < a.length; x++) {
      if (a[x] != correct[x]) {
        checker = false;
      }
    }
    if (checker) {
      System.out.println("Part 5c works!!!");
    }
    else {
      System.out.println("Wrong");
    }
  
  }
  
  public static void main(String[] args) {
    
  }
}
