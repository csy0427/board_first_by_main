import java.util.*;

public class main {
    public static void main(String[] args){

        Scanner input= new Scanner(System.in);
        int choice=0;
        int total_number=0;

        Map<String,List<String>> list;
        List<String> total_list;
        Map<String,Integer> views;


        list= new HashMap<>();
        total_list = new ArrayList<>();
        views= new HashMap<>();

        Calendar date;

        System.out.println("Welcome to the low-level Board World!");
        while(true) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("1. 게시판 리스트");
            System.out.println("2. 게시판 읽기");
            System.out.println("3. 게시판 추가");
            System.out.println("4. 게시판 수정");
            System.out.println("5. 게시판 삭제");
            System.out.println("6.exit.....(가지마....)");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            System.out.println("Enter the number you want (1-6)");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                    case 1:
                        for(int i=0;i<total_list.size();i++){
                            String key=total_list.get(i);//key 획득
                            List<String> tl=list.get(key);
                            System.out.println("     게시글 번호      |          제목           ");
                            System.out.printf("     %s                   %s\n", key, tl.get(0));
                            System.out.println("내용");
                            System.out.println(tl.get(1));
                            System.out.printf("조회수: %d\n",views.get(key));
                        }
                        if(total_list.size()==0) System.out.println("NO POST..");
                        break;

                    case 2:
                        //리스트 먼저 띄워준다..
                        List<String> tl;
                        for(int i=0;i<total_list.size();i++){
                            String key=total_list.get(i);
                            tl=list.get(key);
                            System.out.println("   게시글 번호   |          제목           ");
                            System.out.printf("     %s             %s\n", key, tl.get(0));
                        }
                        if(total_number==0) { System.out.println("NO POST... "); break;}
                        System.out.println("Enter the board number");
                        String id= input.nextLine();
                        while(list.get(id)==null) {
                            System.out.println("You enter the wrong board number.. Enter the correct board number");
                            id= input.nextLine();
                        }
                        tl=list.get(id);
                        System.out.println("   게시글 번호   |          제목           ");
                        System.out.printf("    %s              %s\n", id, tl.get(0));
                        System.out.println("내용");
                        System.out.println(tl.get(1));
                        System.out.printf("조회수: %d\n",views.get(id));
                        ///////////////////////////////////////////////////////
                        int cnt=views.get(id)+1;
                        views.put(id,cnt);
                        break;

                    case 3:
                        date= Calendar.getInstance();
                        System.out.print("제목 :  ");
                        String tmp_title= input.nextLine();
                        System.out.print("내용 :  ");
                        String tmp_contents= input.nextLine();
                        total_number++;
                        String tmp_key=Integer.toString(date.get(Calendar.YEAR))+Integer.toString(date.get(Calendar.MONTH))+
                                Integer.toString(date.get(Calendar.DATE))+Integer.toString(date.get(Calendar.MILLISECOND));
                        total_list.add(tmp_key);
                        List<String> tmp_list=new ArrayList<>();
                        tmp_list.add(tmp_title);
                        tmp_list.add(tmp_contents);
                        list.put(tmp_key,tmp_list);
                        views.put(tmp_key,0);
                        break;

                    case 4:
                        //리스트 먼저 띄워준다..
                        for(int i=0;i<total_list.size();i++){
                            String key=total_list.get(i);
                            tl= list.get(key);
                            System.out.println("   게시글 번호   |          제목           ");
                            System.out.printf("    %s              %s\n", key, tl.get(0));
                        }
                        if(total_number==0) { System.out.println("NO POST... "); break;}
                        System.out.println("Enter the board number");
                        id= input.nextLine();
                        while(list.get(id)==null) {
                            System.out.println("You enter the wrong board number.. Enter the correct board number");
                            id= input.nextLine();
                        }
                        tl=list.get(id);
                        System.out.println("Original Post");
                        System.out.println("   게시글 번호   |          제목           ");
                        System.out.printf("    %s               %s\n", id, tl.get(0));
                        System.out.println("내용");
                        System.out.println(tl.get(1));
                        System.out.println("Enter the new post that you want");
                        System.out.print("제목 :  ");
                        tmp_title= input.nextLine();
                        System.out.print("내용 :  ");
                        tmp_contents= input.nextLine();
                        tmp_list=new ArrayList<>();
                        tmp_list.add(tmp_title);
                        tmp_list.add(tmp_contents);
                        list.put(id,tmp_list);
                        break;

                    case 5:
                        for(int i=0;i<total_list.size();i++){
                            String key=total_list.get(i);
                            tl= list.get(key);
                            System.out.println("   게시글 번호   |          제목           ");
                            System.out.printf("    %s               %s\n", key, tl.get(0));
                        }
                        if(total_number==0) { System.out.println("NO POST... "); break;}
                        System.out.println("Enter the board number");
                        id= input.nextLine();
                        while(list.get(id)==null) {
                            System.out.println("You enter the wrong board number.. Enter the correct board number");
                            id= input.nextLine();
                        }
                        int idx=0;
                        for(int i=0;i<total_list.size();i++){
                           if(total_list.get(i).equals(id))  idx=i;
                        }
                        total_number--;
                        total_list.remove(idx);
                        list.remove(id);
                        views.remove(id);
                        break;

                    case 6:
                        System.out.println("Bye........");
                        System.exit(0);

                default:
                    System.out.println("Enter the number between 1 to 6");
                    break;
                }
        }
    }

}
