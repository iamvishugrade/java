class StringDemo
{

 static int wordCount(String s)
 {
  int index, count = 0;
  String s1 = StringDemo.allTrim(s);
  int length = StringDemo.length(s1);
  for(index = 0; index < length; index++)
  {
   if(s1.charAt(index) == ' ' && s1.charAt(index+1) != ' ')
   count++;
  }
  return count+1;
 }
   
 
 static int spaceCount(String s)
 {
  int index, length, count = 0;
  length = StringDemo.length(s);
  for(index = 0; index<length; index++)
  {
   if(s.charAt(index) == ' ')
   count++;
  }
  return count;
 }
 
 
 static int charCount(String s)
 {
  int count;
  count = StringDemo.length(s) - StringDemo.spaceCount(s);
  return count;
 }
 
 
 static String reverse(String s)
 {
  int length, index;
  length = StringDemo.length(s);;
  char c, ch[] = s.toCharArray();
  for(index = 0; index < length/2;  index++)
  {
   c = ch[index];
   ch[index] = ch[length - index - 1];
   ch[length - index - 1] = c;
  }
  return new String(ch);
 }
 
 static boolean palindrome(String s)
 {
  String s1 = StringDemo.reverse(s);
  int length = StringDemo.length(s1);
  int index = 0;
  while(index<length)
  {
   if(s.charAt(index) == s1.charAt(index))
    index++;
  }
  if(index == length)
   return true;
  else
   return false;
 }
 
 
 static String lTrim(String s)
 {
  int index, length = StringDemo.length(s);
  for(index = 0;index < length;index++)
  {
   if(s.charAt(index) != ' ')
    break;
  }
  return s.substring(index);
 }


 static String rTrim(String s)
 {
  int index, last, length = StringDemo.length(s);
  last = 0;
  for(index = 0;index < length;index++)
  {
   if(s.charAt(index) != ' ')
   last = index;
  }
  return s.substring(0,last+1);
 }
 
 
 static String allTrim(String s)
 {
  return StringDemo.rTrim(StringDemo.lTrim(s));
 }
 
 
 static String squeeze(String s)
 {
  int index, noc = StringDemo.charCount(s);
  char ch[] = new char[noc];
  int length = StringDemo.length(s);
  int fill = 0;
  for(index = 0; index < length; index++)
  {
   if(s.charAt(index) != ' ')
   {
    ch[fill] = s.charAt(index);
    fill++;
   }
  }
  return new String(ch);
 }
 
 
 static int vowelCount(String s)
 {
  int index, count = 0, length;
  length = StringDemo.length(s);
  char ch;
  for(index = 0; index < length; index++)
  {
   ch = s.charAt(index);
   if(ch == 'a' || ch == 'A' || ch == 'e' || ch == 'E' || ch == 'i' || ch == 'I' || ch == 'o' || ch == 'O' || ch == 'u' || ch == 'U' )
   count++;
  }
  return count;  
 }
 
 
 static int length(String s)
 {
  //return (s.toCharArray()).length;
  char ch[] = s.toCharArray();
  int count = 0;
  try{
  while(ch[count] != '\0')
  {
   count++;
  }
  return count;
  }
  finally
  {
   return count;
  }
 }
 
 
 static void sequenceCount(String s)
 {
  int index, count = 0, length;
  length = StringDemo.length(s);
  for(index = 0; index < length; index++)
  {
   try
   {
   if(s.charAt(index) == s.charAt(index+1))
    count++;
   else
   {
    System.out.println(s.charAt(index) +" : " + (count + 1));
	count = 0;
   }
   }
   catch(StringIndexOutOfBoundsException e)
   {
    System.out.println(s.charAt(index) +" : " + (count + 1));
   } 
  }
 }
 
 
 static void frequencyCount(String s)
 {
  int index, index1, count, length;
  length = StringDemo.length(s);
  char c, ch[] = s.toCharArray();
  for(index = 0; index < length; index++)
  {
   c = ch[index];
   if(c == ' ')
   continue;
   count = 0;
   for(index1 = index; index1 < length; index1++)
   {
    if(c == ch[index1])
	 {
	  count++;
	  ch[index1] = ' ';
	 }
   }
   System.out.println(c + " : " + count);
  }
 }
 
 
 static String changeCase(String s)
 {
  byte []b1, b2 = s.getBytes();
  byte b = 32;
  int index, length = StringDemo.length(s);
  b1 = new byte[length];
  for(index = 0; index < length; index++)
  {
   if(b2[index]<=90 & b2[index] >=65)
    b1[index] = (byte)(b2[index] + b);
   else if(b2[index]<=122 & b2[index] >=97)
    b1[index] = (byte)(b2[index] - b);
  }
  return new String(b1);
 }
 
 
 static String singleOccurrence(String s)
 {
  int index, count = 0, length = StringDemo.length(s);
  char c = ' ', ch[] = new char[length];
  for(index = 0; index < length-1; index++)
  {
   if(s.charAt(index) == s.charAt(index+1))
   continue;
   else
   {
    ch[count] = s.charAt(index);
	count++;
   }
  }
  ch[count] = s.charAt(index);
  return new String(ch);
   
 }
 
 
 static String sortedOrder(String s)
 {
  byte temp, b[] = s.getBytes();
  int index1, index2, length = StringDemo.length(s);
  for(index1 = 0; index1 < length-1; index1++)
  {
   for(index2 = index1+1; index2< length; index2++)
   {
    if(b[index1] > b[index2])
	{
	 temp = b[index1];
	 b[index1] = b[index2];
	 b[index2] = temp;
	}
   }
  }
  return new String(b);
 }
 
 
 static String sortedWord(String s)
 {
  int index, index1, index2, previndex, nextindex, wordcount = StringDemo.wordCount(s);
  String str[] = new String[wordcount];
  String temp, str1, s1 = StringDemo.allTrim(s);
  int length = StringDemo.length(s1);
  previndex = 0;
  for(index = 0,index1 = 0; index1 <length; index1++)
  {
   if(s1.charAt(index1) == ' ')
   {
    nextindex = index1;
    str[index++] = s1.substring(previndex, nextindex)+" ";
	previndex = nextindex;
   }
   else
   continue;
  }
  str[index] = s1.substring(previndex);
  
  for(index1 = 0; index1 < wordcount-1; index1++)
  {
   for(index2 = index1+1; index2< wordcount; index2++)
   {
    if(str[index1].compareTo(str[index2])>=0)
	{
	 temp = str[index1];
	 str[index1] = str[index2];
	 str[index2] = temp;
	}
   }
  }
 
  str1 = str[0];
  for(index=1; index<wordcount;index++)
   str1 = str1 + str[index];
  return str1;
 }
 
 
 static boolean find(String s1, String s2)
 {
  int index, length1 = StringDemo.length(s1);
  int length2 = StringDemo.length(s2);
  boolean flag = false;
  for(index = 0; index < length1; index++)
  {
   if((s1.charAt(index) == s2.charAt(0)) && (s1.substring(index, index+length2).equals(s2)))
	{
     flag = true;
	 break;
	}
    
  }
  return flag;   
 }
 
 
 static String replace(String s1, String s2, String s3)
 {
  StringBuffer sb = new StringBuffer(s1);
  if(StringDemo.find(s1,s2))
  {
   int index, length1 = StringDemo.length(s1);
   int length2 = StringDemo.length(s2);
   
   for(index = 0; index < length1; index++)
   {
    if((s1.charAt(index) == s2.charAt(0)) && (s1.substring(index, index+length2).equals(s2)))
	{
	 sb.delete(index, index+length2);
	 sb.insert(index, s3);
	 break;
	}
   }
  }
  else
  System.out.println("Sorry, no match found.");
  return sb.toString();
 }
 
 
 static boolean equals(String s1, String s2)
 {
  int length1, length2, index;
  char []ch1, ch2;
  length1 = StringDemo.length(s1);
  length2 = StringDemo.length(s2);
  
  if(length1 == length2)
  {
   ch1 = new char[length1];
   ch2 = new char[length2];
   for(index = 0; index < length1; index++)
   {
    if(ch1[index] == ch2[index])
	continue;
	else
	break;
   }
   if(index == length1)
   return true;
   else 
   return false;
  }
  else
   return false;
  
 }
 
 
 static void triangle1(String s)
 {
  char ch[] = s.toCharArray();
  int index1, index2, length = StringDemo.length(s);
  for(index1 = 0; index1 <= length; index1++)
  {
   for(index2 = 0; index2< index1; index2++)
   System.out.print(ch[index2]);
   System.out.println();
  }
 }
 
 
 static void triangle2(String s)
 {
  char ch[] = s.toCharArray();
  int index1, index2, length = StringDemo.length(s);
  
  for(index1 = length; index1 >= 0; index1--)
  {
   for(index2 = 0; index2< index1; index2++)
   System.out.print(ch[index2]);
   System.out.println();
  }
 }
 
 
 static void triangle3(String s)
 {
  char ch[] = s.toCharArray();
  int index1, index2, length = StringDemo.length(s);
  for(index1 = 0; index1 <= length; index1++)
  {
   for(index2 = index1; index2< length; index2++)
   System.out.print(ch[index2]);
   System.out.println();
  }
 }
 
 
 static void triangle4(String s)
 {
  char ch[] = s.toCharArray();
  int index1, index2, index3, index4, length = StringDemo.length(s);
  
  for(index1 = length,index3 = 0; index1 >= 0; index1--,index3++)
  {
   for(index2 = 0; index2< index1; index2++)
   System.out.print(ch[index2]);
   for(index4 = 0; index4<index3*2; index4++)
   System.out.print(' ');
   for(index2 = index3; index2< length; index2++)
   System.out.print(ch[index2]);
   System.out.println();
  }
 }
 
 
 static int compare(String s1, String s2)
 {
  byte []b1, b2;
  b1 = s1.getBytes();
  b2 = s2.getBytes();
  int length1, length2, length, index, diff=0;
  length1 = StringDemo.length(s1);
  length2 = StringDemo.length(s2);
  if(length1>=length2)
  length = length2;
  else
  length = length1;
 
  {
  for(index = 0; index < length; index++)
  {
   if(b1[index] == b2[index])
   continue;
   else
   {
    diff = b1[index] - b2[index];
	return diff;
   }
  }
  }
 
  if(length1 != length2)
  {
   if(length2<length1)
    diff = b1[length2];
   else
    diff = b2[length1];
  }
  return diff;
 
 }
 }
 
 class Test
 {
  public static void main(String a[])
  {
   String s = new String("   I am a good boy.    ");
   System.out.println("The given string is : \"" + s + "\"");
   System.out.println("No. of words in the string is : " + StringDemo.wordCount(s));
   System.out.println("No. of spaces in the string is : " + StringDemo.spaceCount(s));
   System.out.println("No. of characters in the string is : " + StringDemo.charCount(s));
   String s1 = "Mohans";
   System.out.println("Reverse of the string " + s1 + " is : " + StringDemo.reverse(s1));
   String s2 = "madam";
   System.out.println("The given string \"" + s2 + "\" is palindrome(true/false): " + StringDemo.palindrome(s2));
   System.out.println("The left trimmed string is : \"" + StringDemo.lTrim(s) + "\"");
   System.out.println("The right trimmed string is : \"" + StringDemo.rTrim(s) + "\"");
   System.out.println("The trimmed string is : \"" + StringDemo.allTrim(s) + "\"");
   System.out.println("The squeezed string is : " + StringDemo.squeeze(s));
   System.out.println("The no. of vowels in the string \"" + s + "\" is : " + StringDemo.vowelCount(s));
   System.out.println("The length of the given string is : " + StringDemo.length(s));
   String s3 = "nniiittiinnni";
   System.out.println("The given string is : \"" + s3 + "\""); 
   System.out.println("The sequence count of the given strring is : ");
   StringDemo.sequenceCount(s3);
   System.out.println("The frequency count of the given string is :");
   StringDemo.frequencyCount(s3);
   String s4 = "INdiA";
   System.out.println("String " + s4 + " is changed to " + StringDemo.changeCase(s4));
   System.out.println("String " + s3 + " is changed to " + StringDemo.singleOccurrence(s3));
   System.out.println("String " + s3 +" is sorted to " + StringDemo.sortedOrder(s3));
   System.out.println("The sorted String is : " + StringDemo.sortedWord(s));
   System.out.println("Is \"am\" available in \"" + s + "\" (true or false) ?"+ StringDemo.find(s,"am"));
   System.out.println(StringDemo.replace(s, "am", "was"));
   System.out.println("hello is equal to hello or not : " + StringDemo.equals("hello", "hello"));
   StringDemo.triangle1("ducat");
   StringDemo.triangle2("ducat");
   StringDemo.triangle3("ducat");
   StringDemo.triangle4("ducat");
   System.out.println(StringDemo.compare("hello", "hello"));
  }
 } 
class Test1
{
public static void main(String s[])
{
StringDemo. frequencyCount("aa ddd aaa ssss dddd rrr sss");

}

}