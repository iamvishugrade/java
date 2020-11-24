class StringDemo
{
	static int count=0,i=0,flag=0,pos=0,length1=0,j=0,loc=0,k=0,max=0,len=0,x=0,s=0,start=0,end=0,total=0,l=0,n=0,m=0;
	static char temp,min;
	static String temp1;


    		static void length1(String s1)
			{
			System.out.println("     ***Program for finding length***    ");
	    		s1=s1+'\0';
	    		char ch[]=s1.toCharArray();
			for(i=0;ch[i]!='\0';i++){
				count++;
    				}
	    			System.out.println("the length of the string is :" + count);
			}




   		static void vowelcount(String s1)
			{
			System.out.println("     ***Program for finding vowel count***    ");
			count=0;
			s1=s1+'\0';
			byte b[]=s1.getBytes();
			for(i=0;b[i]!='\0';i++){
			if((b[i]==97||b[i]==65)||(b[i]==69||b[i]==101)||(b[i]==73||b[i]==105)||(b[i]==79||b[i]==111)||(b[i]==85||b[i]==117)){
				count++;
				}
	
			}
			System.out.println("The number of vowels int given string is:" + count);
	
		}



		static void spacecount(String s1)
		{
		System.out.println("     ***Program for finding space count***    ");
			count=0;
			s1=s1+'\0';
			byte b[]=s1.getBytes();
			for(i=0;b[i]!='\0';i++){
				if(b[i]==32){
					count++;
		
					}

				}
				System.out.println("The number of white spaces :" + count);
			}



		static void charcount(String s1)
		{	
			System.out.println("     ***Program for finding char count***    ");
			count=0;
			s1=s1+'\0';
			byte b[]=s1.getBytes();
			for(i=0;b[i]!='\0';i++){
			if(b[i]!=32){
				count++;

				}

			}
			System.out.println(count);
		}



		static void reverse(String s1)
		{	
			System.out.println("     ***Program for finding reverse***    ");
			char ch[]=s1.toCharArray();
			for(i=0;i<(s1.length()/2);i++){
			count=s1.length()-1;
			temp=ch[count-i];
			ch[count-i]=ch[i];
			ch[i]=temp;

			}
			System.out.println(ch);	

		}



		static void pallindrome(String s1)
		{	
			System.out.println("     ***Program for finding a string is pallindrome or not***    ");
			char ch[]=s1.toCharArray();
			count=s1.length()-1;
			for(i=0;i<(s1.length()/2);i++){
			if(ch[count-i]!=ch[i]){
					flag=1;
					break;
					}
      				} 	
			 if(flag==1){
			System.out.println("String is not a pallindrome");
			}	
			else
			System.out.println("String is a pallindrome");
		}



		static String Ltrim(String s1)
		{
		System.out.println("     ***Program for left trim***    ");
		count=s1.length();
		char ch[]=s1.toCharArray();
		for(i=0;ch[i]==' ';i++){}
		pos=i;
		length1=(s1.length()-i);
		char ch1[]=new char[length1];
		for(j=0,i=pos;j<length1;j++,i++){
			ch1[j]=ch[i];
			}
		//System.out.println(ch1);
		String s2=new String(ch1);
		return s2;

			}



		static String Rtrim(String s1)
		{
			System.out.println("     ***Program for right trim***    ");
			count=s1.length();
			char ch[]=s1.toCharArray();
			for(i=count-1;ch[i]==' ';i--){}
			pos=i+1;
			//System.out.println(pos);
			length1=pos;
			char ch1[]=new char[length1];
			for(j=0,i=0;j<length1;j++,i++){
				ch1[j]=ch[i];
					}
			//System.out.println(ch1);
			String s2=new String(ch1);
			return s2;

			}




		static String allTrim(String s1)
		{
			System.out.println("     ***Program for all trim***    ");
			count=s1.length();
			char ch[]=s1.toCharArray();
			for(i=count-1;ch[i]==' ';i--){}
			for(j=0;ch[j]==' ';j++){}
			pos=i+1;
			loc=j;
			//System.out.println(pos);
			length1=pos-loc+1;
			char ch1[]=new char[length1];
			for(j=0,i=loc;j<length1;j++,i++){
					ch1[j]=ch[i];
						}
				//System.out.println(ch1);
				String s2=new String(ch1);
				return s2;
	

				}




		static int wordcount(String s1)
		{	
			System.out.println("     ***Program for finding word count***    ");
			count=1;i=0;
			char ch[]=s1.toCharArray();
			while(i<(s1.length())&&(ch[i]!='\0')){
				if(i<(s1.length())&&ch[i]!=' '){
					i++;
				
			    		}
				else{
					while(i<(s1.length())&&(ch[i]==' ')){
						i++;
						}
					if(i!=s1.length()){ 
			   			count++;
			   			 }
					}
				}
			return count;
			}
	



		static void sortorder(String s1)
		{	
			System.out.println("     ***Program for sort order***    ");
			char ch[]=s1.toCharArray();
			for(i=0;i<s1.length()-1;i++){
				for(j=i+1;j<s1.length();j++){
					if(ch[i]>ch[j]){
						temp=ch[i];
						ch[i]=ch[j];
						ch[j]=temp;

							}
		
						}

					}
				System.out.println(ch);
				}



	
	static void triangle1(String s1)
	{
	System.out.println("     ***Program for triangle1 type***    ");
	char ch[]=s1.toCharArray();
		for(i=1;i<=s1.length();i++){
			for(j=0;j<i;j++){
				System.out.print(ch[j]);

				}
				System.out.println();

			}
		}




	static void triangle2(String s1)
	{
	System.out.println("     ***Program for triangle2 type***    ");
	char ch[]=s1.toCharArray();
		for(i=s1.length();i>0;i--){
			for(j=0;j<i;j++){
				System.out.print(ch[j]);
					}
					System.out.println();
				}

			}



	static void triangle3(String s1)
	{
	System.out.println("     ***Program for triangle3 type***    ");
	char ch[]=s1.toCharArray();
	for(i=0;i<s1.length();i++){
			for(j=0;j<i;j++){
				System.out.print(" ");
				}
			for(j=i;j<s1.length();j++){
				System.out.print(ch[j]);

			}
			System.out.println();

		}
	}



	static void triangle4(String s1)
	{
	System.out.println("     ***Program for triangle4 type***    ");
	char ch[]=s1.toCharArray();
	for(i=0,k=s1.length();i<s1.length()&&k>0;i++,k--){
		for(j=0;j<k;j++){
			System.out.print(ch[j]);
			}
			for(j=0;j<i;j++){
				System.out.print("  ");
				}
				for(j=i;j<s1.length();j++){
					System.out.print(ch[j]);

					}
					System.out.println();

				}
			}



	static void compare(String s1,String s2)
	{
	System.out.println("     ***Program for comparing strings***    ");
	char ch1[]=s1.toCharArray();
	char ch2[]=s2.toCharArray();
	
	i=0;
	if(s1.length()==s2.length()){
			while(i<s2.length()&&ch1[i]!='\0'&&ch2[i]!='\0'&&ch1[i]==ch2[i]){
				 i++;
				}
				if(i==s1.length()){
				System.out.println("strings are equal");
	
					}
			else{
				System.out.println("the difference is" +(ch2[i]-ch1[i]));
				}
			}	
			if(s1.length()>s2.length()){
				while(i<s2.length()&&ch1[i]!='\0'&&ch2[i]!='\0'&&ch1[i]==ch2[i]){
				i++;
				}
				if(i==s2.length()){
				int x=(int)ch1[i];
				System.out.println(x);

					}
			else{
			System.out.println("the difference is" + (ch2[i]-ch1[i]));
			}
						}
			if(s1.length()<s2.length()){
				while(i<s1.length()&&ch1[i]!='\0'&&ch2[i]!='\0'&&ch1[i]==ch2[i]){
					i++;
					}
					if(i==s1.length()){
						int x=(int)ch2[i];
						System.out.println("the difference is" + x);
							}
						else{
						System.out.println("the difference is" + (ch2[i]-ch1[i]));
						}
					}	
	
				}




			static void squeeze(String s1)
			{
			System.out.println("     ***Program for sueezing string***    ");
			count=0;j=0;
			char ch1[]=s1.toCharArray();
			for(i=0;i<s1.length();i++){
				if(ch1[i]!=32){
					count++;
					}
  				}
			char ch2[]=new char[count];
			for(i=0;i<s1.length();i++){
				if(ch1[i]!=32&&ch1[i]!='\0'){
	
					ch2[j]=ch1[i];
					j++;
					}
				}
				System.out.println(ch2);
	
			}




			static void seqcount(String s1){
			System.out.println("     ***Program for sequence count***    ");
			char ch1[]=s1.toCharArray();
				for(i=0;i<s1.length();i++){	
				count=1;
				for(j=i+1;j<s1.length();j++){
					if(ch1[i]==ch1[j]){
					i++;
					count++;		
						}
					else
					break;
					}
			System.out.println("the number of times " + ch1[i] +"  occur" + count);
			
				}	


			}



			static void freq(String s1)
			{
			System.out.println("     ***Program for frequency count***    ");
			char ch1[]=s1.toCharArray();
			for(i=0;i<s1.length()-1;i++){	
				count=1;flag=0;
				for(k=i-1;k>=0;k--){
					if(ch1[i]==ch1[k]){
						flag=1;
						}
					}
				if(flag==1){
					continue;
					}
				else{
					for(j=i+1;j<s1.length();j++){
						if(ch1[i]==ch1[j]){
							count++;
							}
						}
					}
		System.out.println("the number of times " + ch1[i] +" occured " + count);

				}
																			}
	static boolean equals(String s1,String s2)
	{
	System.out.println("     ***Program for checking string are equal or not***    ");
	char ch1[]=s1.toCharArray();
	char ch2[]=s2.toCharArray();
	i=0;
	while(i<s1.length()&&ch1[i]!='\0'&&ch2[i]!='\0'&&ch1[i]==ch2[i]&&(s1.length())==(s2.length())){
	 	i++;
		}
	if(i==s1.length()){
	System.out.println(true);
	return true;
	
		}
	else{
	System.out.println(false);
	return false;
		}	

	}



	static void find(String s1,String s2)
	{
	System.out.println("     ***Program for finding a string in a given string***    ");
	char ch1[]=s1.toCharArray();
	char ch2[]=s2.toCharArray();
	
	for(i=0;i<s1.length();i++){	
			count=0;
			for(j=0;j<s2.length();j++){
				if(ch1[i]==ch2[j]){
					count++;
					i++;
					}
				else{
				break;
				}
			}
			if(count==s2.length()){
			break;
			}
			

		}
	        if(count==s2.length()){
		System.out.println("String found");
			}
		else
		System.out.println("String not found");

	}




	static void changecase(String s1)
	{
	System.out.println("     ***Program for changing the case of string***    ");
	char ch[]=s1.toCharArray();
	for(i=0;i<s1.length();i++){	
			x=0;
		if(ch[i]>=65&&ch[i]<=91){
			int x=(int)ch[i];
			x=x+32;
			ch[i]=(char)x;

			}
		else{
		int x=(int)ch[i];
		x=x-32;
		ch[i]=(char)x;
		}
	}
	System.out.println(ch);

}



	static void singleoccur(String s1)
	{
	System.out.println("     ***Program for single occurence***    ");
	char ch1[]=s1.toCharArray();
	for(i=0;i<s1.length();i++)
	{	count=1;
		for(j=i+1;j<s1.length();j++)
			{
			if(ch1[i]==ch1[j])
				{
				i++;
				count++;		
				}
			else
			break;
			}
			System.out.print(ch1[i]);
			
	}	

	

	}
	static void replace(String s1,String s2,String s3)
	{
		System.out.println("     ***Program for replacing a string by another***    ");
	char ch1[]=s1.toCharArray();
	char ch2[]=s2.toCharArray();
	char ch3[]=s3.toCharArray();
	len=s2.length();
	for(i=0;i<s1.length();i++){	
		if(count==s2.length()){
		start=i-count-1;
		end=i-2;
		break;
		}
		count=0;
		for(j=0;j<s2.length();j++){
			if(ch1[i]==ch2[j]){
				i++;
				count++;
			}
			else
				break;
		}

	}
	if(count==s2.length()){	
	System.out.println();
	System.out.println("string found");
	System.out.println("The new string is");
	for(i=start,j=0;i<=end&&j<s3.length();i++,j++){	
			ch1[i]=ch3[j];
					}
		System.out.println(ch1);
	
		}
	else {
		System.out.println();
		System.out.println("String not found");

		}

	}




	static void wordsort(String s1)
	{		
			System.out.println("     ***Program for sorting the words of a string***    ");
	
			len=0;count=0;k=0;
			char ch[]=s1.toCharArray();
			for(i=0;i<s1.length();i++){
			if(ch[i]==' ')
			count++;
				}
				len=count+1;
			String[] s2=new String[len];
			j=0;
			
			for(i=0;i<len-1;i++){	
				n=j;
				for(;j<s1.length();j++){	
						
						int k=s1.indexOf(' ',n);
						if(ch[j]==' '){
						j=j+1;
						break;
						}
						m=k;
					}
				
				s2[i]=s1.substring(n,m);
				//System.out.print(" "+s2[i]);


				}
					
				s2[4]=s1.substring(m);
				//System.out.println(" " +s2[4]);
				s=len;
			for(i=0;i<len-1;i++)
				{	
					int max=0;	
					for(j=i+1;j<s;j++)
						{	
						if((s2[j].compareTo(s2[max]))>0)
						{
							max=j;
							//System.out.println(s2[j]);	
							}
						
						}
						s--;
						
							
					if(max!=s)
					{
						temp1=s2[s];
						s2[s]=s2[max];
						s2[max]=temp1;
						
						}
						
					}
	for(i=0;i<len;i++)
	{
	System.out.print(" " +s2[i]+" ");
	}
	System.out.println();
	}



		static void frequency(String s1)
		{	
			System.out.println("     ***Program for checking the frequency of a word***    ");
			len=0;count=0;k=0;
			char ch[]=s1.toCharArray();
			for(i=0;i<s1.length();i++){
			if(ch[i]==' ')
			count++;
				}
				len=count+1;
			String[] s2=new String[len];
			j=0;
			
			for(i=0;i<len-1;i++){
				n=j;
				for(;j<s1.length();j++){	
						
						int k=s1.indexOf(' ',n);
						if(ch[j]==' '){
						j=j+1;
						break;
						}
						m=k;
					}
				
				s2[i]=s1.substring(n,m);
				//System.out.print(" "+s2[i]);


				}
					
				s2[4]=s1.substring(m);
				//System.out.println(" " +s2[4]);
			for(i=0;i<len-1;i++){	
			count=1;flag=0;
			for(k=i-1;k>=0;k--){	
				//System.out.println(count);
				if((s2[i].compareTo(s2[k]))==0){
					flag=1;
					}
				}
				if(flag==1){
				continue;
				}
				else{
				for(j=i+1;j<11;j++){
				if((s2[i].compareTo(s2[j]))==0){
						count++;
						}
					}
				}
			System.out.println("the number of times " + s2[i] +" occured " + count);

			}
		}
	
     public static void main(String...s)
	{	
	length1("hello how are you");
	System.out.println();
	System.out.println();
	vowelcount("hello how are you");
	System.out.println();
	System.out.println();
	spacecount("hello how are you ");
	System.out.println();
	System.out.println();
	charcount("hello how are you");
	System.out.println();
	System.out.println();
	reverse("hello");
	System.out.println();
	System.out.println();
	pallindrome("madam");
	System.out.println();
	System.out.println();
	System.out.println( Ltrim("     hie my name is lovey"));
	System.out.println();
	System.out.println();
	System.out.println( Rtrim("     hie my name is lovey   "));
	System.out.println();
	System.out.println();
	System.out.println( allTrim("     hie my name is lovey   "));
	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println(wordcount("hello hie   how are you   dear    "));
	System.out.println();
	System.out.println();
	triangle1("ducat");
	System.out.println();
	System.out.println();
	triangle2("ducat");
	System.out.println();
	System.out.println();
	triangle3("ducat");
	System.out.println();
	System.out.println();
	compare("ducat","ducat");
	System.out.println();
	System.out.println();
	triangle4("ducat");
	System.out.println();
	System.out.println();
	sortorder("hello");
	System.out.println();
	System.out.println();
	squeeze("i am a good girl");
	System.out.println();
	System.out.println();
	seqcount("nniitn");
	System.out.println();
	System.out.println();
	freq("nniitndfen");
	System.out.println();
	System.out.println();
	equals("ducat","ducat");
	System.out.println();
	System.out.println();
	find("i am a good girl","am");
	System.out.println();
	System.out.println();
	changecase("AtSag klmlkm");
	System.out.println();	
	System.out.println();
	singleoccur("nniflllttin");
	System.out.println();
	System.out.println();
	replace("I am a good girl","good","cute");
	System.out.println();
	System.out.println();
	wordsort("i am a good girl");
	System.out.println();
	System.out.println();
	frequency("India is a good country India is the best country India is good in all sense");
	}

}