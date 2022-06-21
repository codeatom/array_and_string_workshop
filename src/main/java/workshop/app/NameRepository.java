package workshop.app;

import java.util.Arrays;

public class NameRepository {
    private static String[] names = new String[0];

    public static int getSize(){
        return  names.length;
    }

    public static void setNames(String[] names){
        NameRepository.names = names;
    }

    public static void clear(){
        names = new String[0];
    }

    public static String[] findAll(){
        // return Arrays.copyOf(names, names.length);
        return names;
    }

    public static String find(final String fullName){
        for (String name: names) {
            if(fullName.equalsIgnoreCase(name)){
                return name;
            }
        }

        return null;
    }

    public static boolean add(final String fullName){
        for (String name: names) {
            if(name.equalsIgnoreCase(fullName)){
                return false;
            }
        }

        names = addElement(names, fullName);
        return true;
    }

    public static String[] findByFirstName(final String firstName){
        String[] newArray = new String[0];
        String keyWord = "";

        for (String name: names) {
            if(name.split(" ").length > 0){
                keyWord = name.split(" ")[0];
            }

            if(firstName.equalsIgnoreCase(keyWord)){
                newArray = addElement(newArray, name);
            }
        }

        return newArray;
    }

    public static String[] findByLastName(final String lastName){
        String[] newArray = new String[0];
        String keyWord = "";

        for (String name: names) {
            if(name.split(" ").length > 1){
                keyWord = name.split(" ")[1];
            }

            if(lastName.equalsIgnoreCase(keyWord)){
                newArray = addElement(newArray, name);
            }
        }

        return newArray;
    }

    public static boolean update(final String original, final String updatedName){
        for (String name: names) {
            if(name.equalsIgnoreCase(updatedName)){
                return false;
            }
        }

        for (int i = 0; i < names.length; i++){
            if(names[i].equalsIgnoreCase(original)){
                names[i] = updatedName;
                return true;
            }
        }

        return false;
    }

    public static boolean remove(final String fullName){
        /* int index = 0;
        boolean nameIsFound = false;

        for (int i = 0; i < names.length; i++){
            if(names[i].equalsIgnoreCase(fullName)){
                index = i;
                nameIsFound = true;
                break;
            }
        }

        if(nameIsFound){
            for (int i = index; i < names.length-1; i++){
                names[i] = names[i + 1];
            }
            names = Arrays.copyOf(names, names.length - 1);
            return true;
        }

        return false;*/

        for (int i = 0; i < names.length; i++){
            if(names[i].equalsIgnoreCase(fullName)){
                for (int j = i; j < names.length-1; j++){
                    names[j] = names[j + 1];
                }

                names = Arrays.copyOf(names, names.length - 1);
                return true;
            }
        }

        return false;
    }

    public static String[] addElement(String[] strArray, String str){
        String[] newArray = Arrays.copyOf(strArray, strArray.length + 1);
        newArray[newArray.length-1] = str ;

        return newArray;
    }

}
