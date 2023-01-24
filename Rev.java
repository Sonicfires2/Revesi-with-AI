


import java.util.Scanner;



public class Rev {

static int Board_lim=4;

public static int Board[][]=new int[Board_lim][Board_lim];

static Scanner s=new Scanner(System.in);

//Nothing =0

//White =1

//Black =2



public static void init() {

	//Initiate
	for(int i=0; i<Board_lim;i++) {
	    for(int j=0; j<Board_lim;j++) {
	        Board[i][j]=0;
	    }
	}

	Board[1][1]=1;
	Board[1][2]=2;
	Board[2][1]=2;
	Board[2][2]=1;

}



public static void present() {

	//Print board
	System.out.println();
	System.out.print("   a  b  c  d ");
	System.out.println();
	for(int i=0; i<Board_lim;i++) {
	    System.out.print((i+1)+" ");

	    for(int j=0; j<Board_lim;j++) {
	        System.out.print(" "+Board[i][j]+" ");
	    }

	    System.out.println(" "+(i+1));
	}

	System.out.print("   a  b  c  d ");
	System.out.println();
	System.out.println();

}

public static void placeinput(String X,int T) {

	//Place Stone from 'a1' form
	//T=1,2(White,Black)

	if(X.length()!=2) {
	    System.out.println("Input invalid");
	    return; 
	}

	char x=X.charAt(0);
	char y=X.charAt(1);
	int xpos=-1;
	int ypos=-1;

	if((x=='a'||x=='b'||x=='c'||x=='d')&&(y=='1'||y=='2'||y=='3'||y=='4')) {
	    if(x=='a') {
	        xpos=0;
	    }
        else if(x=='b') {
            xpos=1;
        }
        else if(x=='c') {
            xpos=2;
        }

        else if(x=='d') {
            xpos=3;
        }
        if(y=='1') {
            ypos=0;
        }

        else if(y=='2') {
            ypos=1;
        }

        else if(y=='3') {
            ypos=2;
        }

        else if(y=='4') {
            ypos=3;
        }
	}
	else {
        System.out.println("Input invalid");
        return;
	}

	if(xpos!=-1&&ypos!=-1) {
    	placer(xpos,ypos,T);
	}
	else {
	    System.out.println("Unknown Error"+xpos+" "+ypos);
	}
}

public static void placer(int x,int y,int T) {

	//Aux function for placing
	//System.out.println("Place->"+x+" "+y+" "+T);
	//if(Board[y][x]==0) {
	Board[y][x]=T;
	//}
	//else {
	//	System.out.println("Place failed");
	//}

}

public static int[] inputReader(String X) {

	//Translate 'a1' form to int x, int y
	//T=1,2(White,Black)
	int[] Return= {-1,-1};
	if(X.length()!=2) {
	    System.out.println("Input invalid");
	    return Return;
	}

	char x=X.charAt(0);
	char y=X.charAt(1);
	int xpos=-1;
	int ypos=-1;
	if((x=='a'||x=='b'||x=='c'||x=='d')&&(y=='1'||y=='2'||y=='3'||y=='4')) {
	    if(x=='a') {
	    xpos=0;
	    }

	else if(x=='b') {

	xpos=1;

	}

	else if(x=='c') {

	xpos=2;

	}

	else if(x=='d') {

	xpos=3;

	}

	if(y=='1') {

	ypos=0;

	}

	else if(y=='2') {

	ypos=1;

	}

	else if(y=='3') {

	ypos=2;

	}

	else if(y=='4') {

	ypos=3;

	}

	}

	else {

	System.out.println("Input invalid");

	return Return;

	}

	if(xpos!=-1&&ypos!=-1) {

	Return[0]=xpos;

	Return[1]=ypos;

	return Return;

	}

	else {

	System.out.println("Unknown Error"+xpos+" "+ypos);

	return Return;

	}

}

public static int checker(int E,int T,int x,int y,int mode) {

	//Check how many stones can be reversed(-1 is 0)

	//checker(Competitor's color,own color,x,y,Search direction)

	if(mode==0) {

	//Check Up

	if(y==0) {

	return 0;

	}

	else {

	int temp=y;

	int count=0;

	while(temp>0) {

	temp--;

	if(Board[temp][x]==E) {

	count++;

	}

	else if(Board[temp][x]==T) {

	return count;

	}

	else if(Board[temp][x]==0){

	return 0;

	}

	}

	}

	}

	else if(mode==1) {

	//Check down

	if(y==Board_lim-1) {

	return 0;

	}

	else {

	int temp=y;

	int count=0;

	while(temp<Board_lim-1) {

	temp++;

	if(Board[temp][x]==E) {

	count++;

	}

	else if(Board[temp][x]==T) {

	return count;

	}

	else if(Board[temp][x]==0){

	return 0;

	}

	}

	}

	}

	else if(mode ==2) {

	//Check left

	if(x==0) {

	return 0;

	}

	else {

	int temp=x;

	int count=0;

	while(temp>0) {

	temp--;

	if(Board[y][temp]==E) {

	count++;

	}

	else if(Board[y][temp]==T) {

	return count;

	}

	else if(Board[y][temp]==0){

	return 0;

	}

	}

	}

	

	}

	else if(mode ==3) {

	//Check right

	if(x==Board_lim-1) {

	return 0;

	}

	else {

	int temp=x;

	int count=0;

	while(temp<Board_lim-1) {

	temp++;

	if(Board[y][temp]==E) {

	count++;

	}

	else if(Board[y][temp]==T) {

	return count;

	}

	else if(Board[y][temp]==0){

	return 0;

	}

	}

	}

	

	}

	else if(mode ==4) {

	//Check Up left

	if(x==0||y==0) {

	return 0;

	}

	else {

	int temp0=x;

	int temp1=y;

	int count=0;

	while(temp0>0&&temp1>0) {

	temp0--;

	temp1--;

	if(Board[temp1][temp0]==E) {

	count++;

	}

	else if(Board[temp1][temp0]==T) {

	return count;

	}

	else if(Board[temp1][temp0]==0){

	return 0;

	}

	}

	}

	

	}

	else if(mode ==5) {

	//Check down left

	if(x==0||y==Board_lim-1) {

	return 0;

	}

	else {

	int temp0=x;

	int temp1=y;

	int count=0;

	while(temp0>0&&temp1<Board_lim-1) {

	temp0--;

	temp1++;

	if(Board[temp1][temp0]==E) {

	count++;

	}

	else if(Board[temp1][temp0]==T) {

	return count;

	}

	else if(Board[temp1][temp0]==0){

	return 0;

	}

	}

	}

	}

	else if(mode ==6) {

	//Check Up right

	if(x==Board_lim-1||y==0) {

	return 0;

	}

	else {

	int temp0=x;

	int temp1=y;

	int count=0;

	while(temp0<Board_lim-1&&temp1>0) {

	temp0++;

	temp1--;

	if(Board[temp1][temp0]==E) {

	count++;

	}

	else if(Board[temp1][temp0]==T) {

	return count;

	}

	else if(Board[temp1][temp0]==0){

	return 0;

	}

	}

	}

	

	}

	else if(mode ==7) {

	//Check down right

	if(x==Board_lim-1||y==Board_lim-1) {

	return 0;

	}

	else {

	int temp0=x;

	int temp1=y;

	int count=0;

	while(temp0<Board_lim-1&&temp1<Board_lim-1) {

	temp0++;

	temp1++;

	//System.out.println(temp0+"_"+temp1);

	if(Board[temp1][temp0]==E) {

	count++;

	}

	else if(Board[temp1][temp0]==T) {

	return count;

	}

	else if(Board[temp1][temp0]==0){

	return 0;

	}

	}

	}

	

	}

	return -1;

}



public static void fliper(int E,int T,int x,int y,int mode) {

	//Perform flip using information checker(decide direction for flip)

	//flip(Competitor,own,x,y,Search direction)

	if(mode==0) {

	//Check Up

	if(y==0) {

	return ;

	}

	else {

	int temp=y;

	while(temp>0) {

	temp--;

	if(Board[temp][x]==E) {

	Board[temp][x]=T;

	}

	if(Board[temp][x]==T) {

	break;

	}

	}

	}

	}

	else if(mode==1) {

	//Check down

	if(y==Board_lim-1) {

	return ;

	}

	else {

	int temp=y;

	while(temp<Board_lim-1) {

	temp++;

	if(Board[temp][x]==E) {

	Board[temp][x]=T;

	}

	else if(Board[temp][x]==T) {

	

	break;

	}

	}

	}

	}

	else if(mode ==2) {

	//Check left

	if(x==0) {

	return ;

	}

	else {

	int temp=x;

	int count=0;

	while(temp>0) {

	temp--;

	if(Board[y][temp]==E) {

	Board[y][temp]=T;

	}

	else if(Board[y][temp]==T) {

	break;

	}

	

	}

	}

	

	}

	else if(mode ==3) {

	//Check right

	if(x==Board_lim-1) {

	return ;

	}

	else {

	int temp=x;

	while(temp<Board_lim-1) {

	temp++;

	if(Board[y][temp]==E) {

	Board[y][temp]=T;

	}

	else if(Board[y][temp]==T) {

	break;

	}

	}

	}

	

	}

	else if(mode ==4) {

	//Check Up left

	if(x==0||y==0) {

	return ;

	}

	else {

	int temp0=x;

	int temp1=y;

	while(temp0>0&&temp1>0) {

	temp0--;

	temp1--;

	if(Board[temp1][temp0]==E) {

	Board[temp1][temp0]=T;

	}

	else if(Board[temp1][temp0]==T) {

	break;

	}

	}

	}

	

	}

	else if(mode ==5) {

	//Check down left

	if(x==0||y==Board_lim-1) {

	return ;

	}

	else {

	int temp0=x;

	int temp1=y;

	while(temp0>0&&temp1<Board_lim-1) {

	temp0--;

	temp1++;

	if(Board[temp1][temp0]==E) {

	Board[temp1][temp0]=T;

	}

	else if(Board[temp1][temp0]==T) {

	break;

	}

	}

	}

	}

	else if(mode ==6) {

	//Check Up right

	if(x==Board_lim-1||y==0) {

	return ;

	}

	else {

	int temp0=x;

	int temp1=y;

	while(temp0<Board_lim-1&&temp1>0) {

	temp0++;

	temp1--;

	if(Board[temp1][temp0]==E) {

	Board[temp1][temp0]=T;

	}

	else if(Board[temp1][temp0]==T) {

	break;

	}

	}

	}

	

	}

	else if(mode ==7) {

	//Check down right

	if(x==Board_lim-1||y==Board_lim-1) {

	return ;

	}

	else {

	int temp0=x;

	int temp1=y;

	while(temp0<Board_lim-1&&temp1<Board_lim-1) {

	temp0++;

	temp1++;

	//System.out.println(temp0+"_"+temp1);

	if(Board[temp1][temp0]==E) {

	Board[temp1][temp0]=T;

	}

	else if(Board[temp1][temp0]==T) {

	break;

	}

	}

	}

	

	}

}



public static void checkflip(int E,int T,int x,int y) {

	//Aux function for flip(Connects Checker->fliper)

	int temp=0;

	for(int i=0;i<8;i++) {

	temp=checker(E,T,x,y,i);

	if(temp>=1) {

	//System.out.println("Flip" +i);

	fliper(E,T,x,y,i);

	}

	}

}



public static int checkvalication(int E,int T,int x,int y) {

	//Check how many stones can be reversed for every directions(8 directions)

	if(Board[y][x]!=0) {

	return -2;

	}

	else {

	int count=0;

	int temp=0;

	for(int i=0;i<8;i++) {

	temp=checker(E,T,x,y,i);

	if(temp==-1) {

	//System.out.println("counting Warn"+"---"+"checker"+E+","+T+","+x+","+y+","+i+"");

	temp=0;

	}

	else {

	count=count+temp;

	temp=0;

	}

	}

	return count;

	}

}

public static String[] Legal_place(int E,int T) {

	//Return String Array(end with letter"Last") in all available choices

	String[] Return=new String[Board_lim*Board_lim];

	int Last=0;

	for(int i=0;i<Board_lim;i++) {

	for(int j=0;j<Board_lim;j++) {

	if(checkvalication(E,T,j,i)>0) {

	if(j==0) {

	Return[Last]="a"+(i+1);

	}

	else if(j==1) {

	Return[Last]="b"+(i+1);

	}

	else if(j==2) {

	Return[Last]="c"+(i+1);

	}

	else if(j==3) {

	Return[Last]="d"+(i+1);

	}

	Last++;

	}

	}

	}

	Return[Last]="Last";

	return Return;

}

public static int Legal_place_printer(int E,int T) {

	//Print Every available choices and return how many available choices(if 0, main method will decide end game or pass)

	int Return=0;

	System.out.println();

	String[] H=Legal_place(E,T);

	if(H[0].equals("Last")){

	System.out.println("No place avalible");

	return 0;

	}

	else {

	int i=0;

	while(true) {

	if(H[i].equals("Last")) {

	break;

	}

	System.out.print(H[i]+" ");

	Return++;

	i++;

	}

	}

	System.out.println();

	return Return;

}



public static boolean Is_Legal(String X,String[] H) {

	//Usually takes String[] from Legal_place and check with UserInput.

	if(H[0].equals("Last")){

	System.out.println("Pass unsuccessful Error");

	return false;

	}

	else {

	int i=0;

	while(true) {

	if(H[i].equals("Last")) {

	return false;

	}

	if(H[i].equals(X)) {

	return true;

	}

	i++;

	}

	}

	

}

public static  int[] counter() {

	int[] Return = new int[3];

	//Blank [0]

	//White [1]

	//Black [2]

	for(int i=0;i<Board_lim;i++) {

	for(int j=0;j<Board_lim;j++) {

	Return[Board[i][j]]++;

	}

	}

	return Return;

}

//public static void main(String[] args) {

// 	init();

// 	placeinput("b1",2);

// 	placeinput("a4",2);

// 	placeinput("a1",2);

// 	placeinput("b2",1);

// 	placeinput("b3",1);

// 	placeinput("b4",1);

// 	placeinput("c2",1);

// 	placeinput("c3",1);

// 	placeinput("c4",1);

// 	placeinput("d4",2);

// 	present();

// 	checkflip(1,2,0,0);

// 	present();

// 	

// }





 public static void main(String[] args) {

 	Scanner s=new Scanner(System.in);

 	int Usermode=-1;

 	while(true) {

 	System.out.println("Do you want to play DARK (2) or LIGHT (1)?");

 	int A=s.nextInt();

 	if(!(A==2||A==1)) {

 	System.out.println("Invalid input");

 	}

 	else {

 	Usermode=A;

 	break;

 	}

 	}

 	s.nextLine();

 	init();

 	

 	int Endcount=0;

 	//if pass, ++ not passed, reset to 0

 	//if this get 2, end

 	

 	

 	 //User LIGHT

 	if(Usermode==1) {

 	while(true) {

 	present();

 	System.out.println("Turn of DARK(2)-com");

 	//This should played by AI but for now, played by human

 	String[] H=Legal_place(1,2);

 	if(Legal_place_printer(1,2)==0) {

 	//if no choice, pass

 	System.out.println("Pass");

 	Endcount++;

 	if(Endcount>=2) {

 	//Passed twice, end game

 	System.out.println("DONE");

 	return;

 	}

 	}

 	else {

 	Endcount=0;

 	while(true) {

 	//Takes Userinput until good input coming in

 	String A=s.nextLine();

 	if(Is_Legal(A,H)) {

 	placeinput(A,2);

 	int[] HA= inputReader(A);

 	checkflip(1,2,HA[0],HA[1]);

 	break;

 	}

 	else {

 	int[] z=counter();

 	System.out.println("Blank="+z[0]+" White="+z[1]+" Black="+z[2]);

 	System.out.println("Try again");

 	}

 	}

 	}

 

 	present();

 	System.out.println("Turn of LIGHT(1)-User");

 	H=Legal_place(2,1);

 	if(Legal_place_printer(2,1)==0) {

 	System.out.println("Pass");

 	Endcount++;

 	if(Endcount>=2) {

 	int[] z=counter();

 	System.out.println("Blank="+z[0]+" White="+z[1]+" Black="+z[2]);

 	System.out.println("DONE");

 	return;

 	}

 	}

 	else {

 	Endcount=0;

 	while(true) {

 	String A=s.nextLine();

 	if(Is_Legal(A,H)) {

 	placeinput(A,1);

 	int[] HA= inputReader(A);

 	checkflip(2,1,HA[0],HA[1]);

 	break;

 	}

 	else {

 	System.out.println("Try again");

 	}

 	}

 	}	

 	}

 	}

 	

 	

 	// USER DARK

 	else if(Usermode==2) {

 	while(true) {

 	present();

 	System.out.println("Turn of DARK(2)-User");

 	String[] H=Legal_place(1,2);

 	if(Legal_place_printer(1,2)==0) {

 	System.out.println("Pass");

 	Endcount++;

 	if(Endcount>=2) {

 	int[] z=counter();

 	System.out.println("Blank="+z[0]+" White="+z[1]+" Black="+z[2]);

 	System.out.println("DONE");

 	return;

 	}

 	}

 	else {

 	Endcount=0;

 	while(true) {

 	String A=s.nextLine();

 	if(Is_Legal(A,H)) {

 	//System.out.println(Is_Legal(A,H));

 	placeinput(A,2);

 	int[] HA= inputReader(A);

 	checkflip(1,2,HA[0],HA[1]);

 	break;

 	}

 	else {

 	System.out.println("Try again");

 	}

 	}

 	

 	}

 

 	present();

 	System.out.println("Turn of LIGHT(1)-com");

 	H=Legal_place(2,1);

 	if(Legal_place_printer(2,1)==0) {

 	System.out.println("Pass");

 	Endcount++;

 	if(Endcount>=2) {

 	int[] z=counter();

 	System.out.println("Blank="+z[0]+" White="+z[1]+" Black="+z[2]);

 	System.out.println("DONE");

 	return;

 	}

 	}

 	else {

 	Endcount=0;

 	while(true) {

 	String A=s.nextLine();

 	if(Is_Legal(A,H)) {

 	placeinput(A,1);

 	int[] HA= inputReader(A);

 	checkflip(2,1,HA[0],HA[1]);

 	break;

 	}

 	else {

 	System.out.println("Try again");

 	}

 	}

 	}	

 	}

 	}
    }
}

