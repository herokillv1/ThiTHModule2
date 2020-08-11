
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneManager {
    public static Scanner sc = new Scanner(System.in);
    private static final String PATH = "CSV/filePhoneNumber.csv";
    private List<PhoneList> phoneLists;
    private ReadAndWrite<PhoneList> readAndWrite;

    public PhoneManager() {
        readAndWrite = new ReadAndWrite<>();
        phoneLists = readAndWrite.readFile(PATH);
    }

    public void show(){
        for (PhoneList phoneList : phoneLists){
            System.out.println(phoneList.getNumber()+"--"+phoneList.getGroup()+"--"+phoneList.getName()+"--"+phoneList.getGender()+"--"+phoneList.getAddress()+"--"+phoneList.getDob()+"--"+phoneList.getEmail());
        }
    }

    public void add() {
        System.out.println("Số điện thoại :");
        String number = sc.nextLine();
        System.out.println("Nhóm :");
        String group = sc.nextLine();
        System.out.println("Họ tên :");
        String name = sc.nextLine();
        System.out.println("Giới tính :");
        String gender = sc.nextLine();
        System.out.println("Địa chỉ :");
        String address = sc.nextLine();
        System.out.println("Ngày sinh :");
        String dob = sc.nextLine();
        System.out.println("Email :");
        String email = sc.nextLine();

        PhoneList phoneList = new PhoneList(number, group, name, gender, address, dob, email);
        phoneLists.add(phoneList);
        readAndWrite.writeFile(PATH, phoneLists);
    }

    public void edit() {
        boolean check = true;
        while (check) {
            String number = sc.nextLine();
            if (number.equals("")) {
                break;
            } else {
                for (PhoneList phoneList : phoneLists) {
                    if (number.equals(phoneList.getNumber())) {
                        check = false;
                        System.out.println("Sửa nhóm " + phoneList.getGroup() + " thành :");
                        String group = sc.nextLine();
                        phoneList.setGroup(group);
                        System.out.println("Sửa họ tên " + phoneList.getName() + " thành :");
                        String name = sc.nextLine();
                        phoneList.setName(name);
                        System.out.println("Sửa giới tính " + phoneList.getGender() + " thành :");
                        String gender = sc.nextLine();
                        phoneList.setGender(gender);
                        System.out.println("Sửa địa chỉ " + phoneList.getAddress() + " thành :");
                        String address = sc.nextLine();
                        phoneList.setAddress(address);
                        System.out.println("Sửa ngày sinh " + phoneList.getDob() + " thành :");
                        String dob = sc.nextLine();
                        phoneList.setDob(dob);
                        System.out.println("Sửa email " + phoneList.getEmail() + " thành :");
                        String email = sc.nextLine();
                        phoneList.setEmail(email);
                        System.out.println("Đã sủa thành công");
                    }
                }
                if (check){
                    System.out.println("Ko tồn tại SĐT này . Nhập lại");
                }
            }
        }
        if (!check){
            readAndWrite.writeFile(PATH,phoneLists);
        }
    }

    public void delete(String number){
        PhoneList phoneList = null;
        for (int i=0; i<phoneLists.size();i++){
            if (number.equals(phoneLists.get(i).getNumber())){
                phoneList = phoneLists.get(i);
                break;
            }
        }
        if (phoneList != null){
            System.out.println("Đã xóa sđt : " + phoneList.getNumber());
            System.out.println();
            phoneLists.remove(phoneList);
            readAndWrite.writeFile(PATH,phoneLists);
        }else {
            System.out.println("Số ĐT ko tồn tại");
        }
    }

    public boolean checkKey(String key , String input){
        key = key.toUpperCase();
        String regex = ".*" + key + ".*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input.toUpperCase());
        return matcher.matches();
    }

    public void  searchProduct(String key){
        List<PhoneList> productsListsSearch = new ArrayList<>();
        Iterator<PhoneList> iterator = phoneLists.iterator();
        while (iterator.hasNext()){
            PhoneList productsList = iterator.next();
            if (checkKey(key,productsList.getName())||checkKey(key,productsList.getNumber())){
                productsListsSearch.add(productsList);
            }
        }
        for (PhoneList phoneList : productsListsSearch){
            System.out.println(phoneList.getNumber()+"--"+phoneList.getGroup()+"--"+phoneList.getName()+"--"+phoneList.getGender()+"--"+phoneList.getAddress()+"--"+phoneList.getDob()+"--"+phoneList.getEmail());
        }
    }
}