import java.util.ArrayList;
import java.util.HashMap;

public class Practicum {
    public static void main(String[] args) {
        //создаём двухуровневую хеш-таблицу для хранения расписания уроков
        AdvancedHashMap<String, Integer, String> timetable = new AdvancedHashMap<>();
        //добавляем уроки, с указанием дня недели и номера урока
        timetable.put("Понедельник", 1, "Русский язык");
        timetable.put("Понедельник", 2, "Математика");
        timetable.put("Вторник", 1, "Физкультура");
        timetable.put("Вторник", 2, "Русский язык");

        //выводим первый урок во вторник
        System.out.println(timetable.get("Вторник", 1));

        //получаем и выводим все уроки в понедельник
        ArrayList<String> mondayLessons = timetable.getAll("Понедельник");
        System.out.println(mondayLessons);
    }

}

class AdvancedHashMap<T1, T2, T3> { //...
    //данные будем хранить в хеш-таблице из хеш-таблиц
    HashMap<T1, HashMap<T2, T3>> internalHashMap = new HashMap<>();

    public void put(T1 day, T2 numberLeson, T3 subject) {
        //получаем хеш-таблицу по первому ключу
        HashMap<T2,T3> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            //вложенной хеш-таблицы по первому ключу пока нет — создаём её и добавляем в internalHashMap
            innerHashMap = new HashMap<>();
            innerHashMap.put(numberLeson, subject);
        }
        //добавляем элемент во вложенную хеш-таблицу
        innerHashMap.put(numberLeson, subject);
        internalHashMap.put(day, innerHashMap);
    }

    public T3 get(T1 day, T2 numberLesson) {
        //получаем хеш-таблицу по первому ключу
        HashMap<T2,T3> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return null;
        }
        //получаем элемент из вложенной хеш-таблицы
        return internalHashMap.get(day).get(numberLesson);
    }

    public ArrayList<T3> getAll(T1 day) {
        HashMap<T2,T3> innerHashMap = internalHashMap.get(day);
        if (innerHashMap == null) {
            return new ArrayList<>();
        }
        return new ArrayList(innerHashMap.values());
    }

//  поменяли второй комментарий
    // добавили комментарии после слияяния и удаление ветки на гит хабе
    // добавили совсем новый комментарий
    // добавить новейший комментарий для нагдядности
    // что то добавили после слияния
    // еще что то добавили
    // пошли по новой ветке
    

}