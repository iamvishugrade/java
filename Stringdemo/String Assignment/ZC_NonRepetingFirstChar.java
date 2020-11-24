class ZC_NonRepetingFirstChar
{
	static void firstNonRepetingCharacter(String s)
	{

		char ch[]=s.toCharArray();

		char cha=' ';
		for(int i=0;i<ch.length; i++)
		{
			int c=0;
			for(int j=0; j<ch.length; j++)
			{
				if(ch[i]==ch[j])
				{
					c=c+1;
				}
				if(ch[i]!=ch[j])
					cha=ch[i];
			}
			if(c<=1)
			break;
		}
		System.out.println(cha);
	}
	public static void main(String[] args) {
		firstNonRepetingCharacter("IndIia");
	}
	
}
