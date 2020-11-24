class Trim
{
//to remove the spaces from the right and left of a String..............
	static String allTrim(String s) 
	{
        int len = s.length();
        int st=0;
        char val[] = s.toCharArray();
		
        while ((st < len) && (val[st] == ' ')) 
		{
            st++;
        }
        
		while ((st < len) && (val[len - 1] == ' ')) 
		{
            len--;
        }
		//System.out.println(len +"    "+ st);
		
		String s1=s.substring(st,len);
		return s1;
        
    }

//to remove the spaces from the right of a String..............
	static String rTrim(String s) 
	{
        int len = s.length();
        int st=0;
        char val[] = s.toCharArray();
		
/*		while ((st < len) && (val[st] == ' ')) 
		{
            st++;
        }*/
        
		while ((st < len) && (val[len - 1] == ' ')) 
		{
            len--;
        }
		//System.out.println(len +"    "+ st);
		
		String s1=s.substring(st,len);
		return s1;
        
    }

//to remove the spaces from the left of a String..............
	static String lTrim(String s) 
	{
        int len = s.length();
        int st=0;
        char val[] = s.toCharArray();
		
		while ((st < len) && (val[st] == ' ')) 
		{
            st++;
        }
        
		/*while ((st < len) && (val[len - 1] == ' ')) 
		{
            len--;
        }*/
		//System.out.println(len +"    "+ st);
		
		String s1=s.substring(st,len);
		return s1;
        
    }
	
//to remove all the spaces in a String..............
	static String squeeze(String s) 
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		
		for(int i=0;i<len;i++)
		{
			if(ch[i]!=' ')
				st++;
		}
		
		int c=0;
		char ch1[]=new char[st];
		
		for(int i=0;i<len;i++)
		{
			if(ch[i]!=' ')
			{
				ch1[c]=ch[i];
				c++;
			}
		}
		String s1=new String(ch1);
		//System.out.println(st);
		return s1;
        
    }

//to find length of a String..............
	static int length(String s) 
	{
		int st=0;
		try{
		char ch[] = s.toCharArray();
		while(ch[st] != 0)
		{
			st++;
		}
		System.out.println(st);
		return st;
        }
		catch(ArrayIndexOutOfBoundsException e)
		{
			//System.out.println(e);
		}
		finally
		{
			return st;
		}
    }


//to count vowels in a String............
	static int vowelCount(String s)
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		
		for(int i=0;i<len;i++)
		{
			if((ch[i]=='a')||(ch[i]=='e')||(ch[i]=='i')||(ch[i]=='o')||(ch[i]=='u')||(ch[i]=='A')||(ch[i]=='E')||(ch[i]=='I')||(ch[i]=='O')||(ch[i]=='U'))
				st++;
		}	
		return st;
	}
	
//to count all the spaces in a String..............
	static int spaceCount(String s) 
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		
		for(int i=0;i<len;i++)
		{
			if(ch[i]==' ')
				st++;
		}
		
		//System.out.println(st);
		return st;
        
    }

//to count all the characters in a String..............
	static int charCount(String s) 
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		
		for(int i=0;i<len;i++)
		{
			if(ch[i]!=' ')
				st++;
		}
		
		//System.out.println(st);
		return st;
        
    }

//to reverse a String..............
	static String reverse(String s) 
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		char ch1[]=new char[len];
		for(int i=(len-1);i>=0;i--)
		{
			ch1[st]=ch[i];
			st++;
		}
		String s1=new String(ch1);
		//System.out.println(st);
		return s1;
        
    }
	
//to check weather a String is Palindrome or not!!..............
	static boolean palindrome(String s) 
	{
		int len=s.length();
		int st=0;
		char ch[] = s.toCharArray();
		char ch1[]=new char[len];
		for(int i=(len-1);i>=0;i--)
		{
			ch1[st]=ch[i];
			st++;
		}
		
		String s1=new String(ch1);
		if(s.equals(s1))
			return true;
		else
			return false;
        
    }
	
//to count words in a String..............
	static int wordCount(String s)
	{
		int i,c=0,res;
		char ch[]= new char[s.length()]; 
		for(i=0;i<s.length();i++)
		{
			ch[i]= s.charAt(i);
		
			if( ( (i>0) && (ch[i]!=' ') && (ch[i-1]==' ') ) || ( (ch[0]!=' ') && (i==0) ) )
				c++;
		}
		return c; 
	}	

//Triangle1............
	static void triangle1(String s)
	{
		int l=s.length();
		for (int i=0; i<l; ++i) 
		{
			for (int j=0; j<=i; ++j) 
			{
				System.out.print( s.charAt(j) );
			}
			System.out.println();
		}

	}

//Triangle2............
	static void triangle2(String s)
	{
		int l=s.length();
		for (int i=(l-1); i>=0; --i) 
		{
			for (int j=0; j<=i; ++j) 
			{
				System.out.print( s.charAt(j) );
			}
			System.out.println();
		}

	}

//Triangle3............
	static void triangle3(String s)
	{
		int l=s.length();
		int i,j, k;
        int m = s.length();
        int n = m;

        for (i=1; i <= n; i++) 
		{
            for (j=i-2; j >= 0; j--) 
			{
                System.out.print(" ");
            }
			for (k=i-1; k <m; k++) 
			{
                        System.out.print(s.charAt(k));
            }
            
            System.out.println();
            
        }
	}

//Triangle4............
	static void triangle4(String s)
	{
		char ch[]=s.toCharArray();
		int i, j, k, l;
		for(i=0;i<ch.length;i++)
		{
			for(l=0;l<ch.length-i;l++)
			{
				System.out.print(ch[l]);
			}
			for(k=0;k<i;k++)
			{
				System.out.print(" ");
			}
			for(k=0;k<i;k++)
			{
				System.out.print(" ");
			}
			for(j=k;j<ch.length;j++)
			{
				System.out.print(ch[j]);
			}
			System.out.println();
        }
	}

//to arrange the words in sorting manner..........
	static void sortedWord( String s)
	{	
		String x[]=s.split(" ");
		int i, j;
		String temp;
		for ( i = 0;  i < x.length - 1;  i++ )
		{
			for ( j = i + 1;  j < x.length;  j++ )
			{ 
				if ( x [ i ].compareToIgnoreCase( x [ j ] ) > 0 )
				{ 
					temp = x [ i ];
					x [ i ] = x [ j ];    
					x [ j ] = temp;
				}
			}
		}
		
		for ( i = 0;  i < x.length;  i++ )
		{
			System.out.print("  "+ x[i]);
		}
	}

//to sort a string.......
	static String sortOrder(String s)
	{
		char ch[]=s.toCharArray();
		char l;
		for(int i=0; i<ch.length; i++)
		{
			for(int j=0; j<(ch.length-1); j++)
			{
				if((((int)ch[j])-((int)(ch[j+1])))>0)
				{
					l=ch[j];
					ch[j]=ch[j+1];
					ch[j+1]=l;
				}
			}
		}
		String s1=new String(ch);
		return s1;
	}

//to count the frequency of character in Sequence............. 
	static void sequenceCount(String s)
	{
		int i,g=0,f=0; char d; 
		char ch[] = s.toCharArray();
		int fr[]; char ele[];
		int l=ch.length;
		fr=new int[l];
		ele=new char[l];
		d=ch[0];
		for(i=0;i<(ch.length-1);i++)
		{
			if(d!=ch[i])
			{
				ele[g]=d;
				fr[g]=f;
				g++;
				d=ch[i];
				f=1;
			}
			else
			{
				f++;
			}
			ele[g]=d;
			fr[g]=f;
		}
		System.out.println("element"+"\t"+"frequency");
		for(i=0;i<ch.length;i++)
		{
			if(fr[i]!=0)
			{
				System.out.println(ele[i]+"\t"+fr[i]);
			}
		} 
	}


//to count the frequency of characters in a string......	
	static void frequencyCount(String s)
	{
		String s2=sortOrder(s);
		sequenceCount(s2);
	}

//to reverse the case in a string........
	static String changeCase(String s)
	{
		char ch[]=s.toCharArray();
		char ch1[]=new char[ch.length];
		int i,j;  char t;
		char sl[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		char cl[]={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		for(i=0;i<ch.length;i++)
		{
			for(j=0;j<26;j++)
			{
				if(ch[i]==sl[j])
					ch1[i]=cl[j];
				else if(ch[i]==cl[j])
					ch1[i]=sl[j];
			}
			
		}
		String s1=new String(ch1);
		return s1;
	}
	
//to print a string with Single Occurrence............. 
	static String singleOccurrence(String s)
	{
		int i,c=0,g=0,f=0; char d; 
		char ch[] = s.toCharArray();
		int fr[]; char ele[];
		int l=ch.length;
		fr=new int[l];
		ele=new char[l];
		d=ch[0];
		for(i=0;i<(ch.length-1);i++)
		{
			if(d!=ch[i])
			{
				ele[g]=d;
				fr[g]=f;
				g++;
				d=ch[i];
				f=1;
			}
			else
			{
				f++;
			}
			ele[g]=d;
			fr[g]=f;
		}
		
		String s1=new String(ele);
		
		/*System.out.println("element"+"\t"+"frequency");
		for(i=0;i<ch.length;i++)
		{
			if(fr[i]!=0)
			{
				System.out.println(ele[i]+"\t"+fr[i]);
			}
		}*/
		
		return s1; 
	}
//to find weather the two strings equal or not!!.......... 
	static boolean equals(String s1, String s2)
	{
		int i=0;
		char ch1[]=s1.toCharArray();
		char ch2[]=s2.toCharArray();
		int n=ch1.length;
		int m=ch2.length;
		if(n!=m)
			return false;
		{
			while (n-- != 0) 
			{
				if (ch1[i] != ch2[i])
					return false;
					i++;
			}
		}
		return true;		
	}			

	
//to find a string into another...........
	static boolean find(String s1, String s2)
	{
		String words[]=s1.split(" ");
		for(int i=0;i<words.length;i++)
		{
			boolean b=equals(words[i],s2);
			if(b==true)
			{
				return true;
			}
		}
		return false;
	}		
//to replace a string with another in a 3rd string...........	
	static String replace(String s1, String s2, String s3)
	{
		String words[]=s1.split(" ");
		String s="";
		for(int i=0;i<words.length;i++)
		{
			boolean b=equals(words[i],s2);
			if(b==true)
			{
				words[i]=s3;
			}
			s=s.concat(words[i]+" ");
		}
		return(s);
	}	

//to find the word frequency............
    static void wordFrequencyCount(String s)
	{
		String words[]=s.split(" ");
		int i,j,k,f=1,m=-1,c;  
		System.out.println("Word\t\t\tFrequency");	
		for(i=0;i<words.length;i++)
		{
			for(j=0;j<=m;j++)
			{
				if(equals(words[i],words[j]))
				{
					f=0;;
				}
			}
			if(f==1)
			{
				m++;
				words[m]=words[i];
				c=1;
				for(k=i+1;k<words.length;k++)
				{
					if(equals(words[i],words[k]))
					{
						c++;
					}
				}
				System.out.println(words[m]+"\t\t\t"+c);	
			}
			f=1;		
		}				
	}

	
	
	public static void main(String... s)
	{
		System.out.print(allTrim("         i           am      the               best           i am the bestest                      "));
		System.out.println(" allTrim \n\n");
		System.out.print(rTrim("         i am the best           i am the bestest                      "));
		System.out.println(" rTrim \n\n");
		System.out.print(lTrim("         i am the best           i am the bestest                      "));
		System.out.println(" lTrim \n\n");
		System.out.print(squeeze("   i am the best           i am the bestest    "));
		System.out.println("\t squeeze \n\n");
		System.out.print(length("   i am the best           i am the bestest    "));
		System.out.println("\t length \n\n");
		System.out.print(vowelCount("   i am the best           i am the bestest    "));
		System.out.println("\t vowelCount \n\n");
		System.out.print(spaceCount("   i am the best           i am the bestest    "));
		System.out.println("\t spaceCount \n\n");
		System.out.print(charCount("   i am the best           i am the bestest    "));
		System.out.println("\t charCount \n\n");
		System.out.print(reverse("tseb eht ma i    i am the best"));
		System.out.println("\t reverse \n\n");
		System.out.print(palindrome("tseb eht ma i  i am the best"));
		System.out.println("\t palindrome \n\n");
		System.out.print(wordCount("     i    am    the    best           i   am   the    bestest    "));
		System.out.println("\t wordCount \n\n");
		triangle1("ducat");
		System.out.println("\t Triangle1 \n\n");
		triangle2("ducat");
		System.out.println("\t Triangle2 \n\n");
		triangle3("ducat");
		System.out.println("\t Triangle3 \n\n");
		triangle4("ducat");
		System.out.println("\t\t Triangle4 \n\n");
		sortedWord("i am the best");
		System.out.println("\n\n\t SortedWord \n\n");
		System.out.println(sortOrder("fedcba ashish anuj"));
		System.out.println("\n\n\t SortOrder \n\n");
		sequenceCount("aaaaasssssshhhhhhiiiiiiiisssssshhhhhh");
		System.out.println("\n\n\t SequenceCount \n\n");
		frequencyCount("aaaaasssssshhhhhhiiiiiiiisssssshhhhhh");
		System.out.println("\n\n\t FrequencyCount \n\n");
		System.out.println("ABCDEFGHIJKLmnopqrsTuvwxYz");
		System.out.println(changeCase("ABCDEFGHIJKLmnopqrsTuvwxYz AsHiSh JaIn"));
		System.out.println("\n\n\t ChangeCase \n\n");
		System.out.print(singleOccurrence("aaaaasssshhhhhhhiiiiissssshhhhhhhh"));
		System.out.println("\t singleOccurrence \n\n");
		System.out.println(equals("Ashish","Ashish"));
		System.out.println("\t Equals \n\n");
		System.out.print(find("i am the best","best"));
		System.out.println("\t Find \n\n");
		System.out.print(replace("i am the best","best","bestest"));
		System.out.println("\t Replace \n\n");
		wordFrequencyCount("i m the best i am the bestest i m the best i am the bestest i m the best i am the bestest i m the best i am the bestest");
		System.out.println("\t Word Frequency Count \n\n");

	}
	
}