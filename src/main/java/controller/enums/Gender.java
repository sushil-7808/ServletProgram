package controller.enums;

public enum Gender {

    MALE, FEMALE, OTHERS;
    // 0, 1, 2

    public static Gender findByOrdinal(int ordinal){
        Gender [] genders = Gender.values();
        for (Gender g: genders){
            if(ordinal ==g.ordinal()){
                return g;
            }
        }
        return null;
    }
}
