package yehor.lab4.controller;

import yehor.lab4.model.Human;
import yehor.lab4.model.Sex;

import java.util.Random;

/**
 * Створює людей з випадковими, але правдоподібними українськими ПІБ.
 */
public class HumanCreator {

    private static final String[] LAST_NAMES = {
        "Добровольський", "Яковенко", "Білоус", "Гордієнко", "Тимошенко", "Олійник",
        "Ковальчук", "Пономаренко", "Нестеренко", "Чорновол", "Головко", "Семенюк"
    };
    private static final String[] MALE_NAMES = {
        "Єгор", "Владислав", "Артем", "Назар", "Денис", "Кирило", "Ярослав", "Віталій"
    };
    private static final String[] FEMALE_NAMES = {
        "Дарина", "Вікторія", "Аліна", "Христина", "Поліна", "Валерія", "Оксана", "Яна"
    };
    private static final String[] FATHER_NAMES = {
        "Андрій", "Юрій", "Олег", "Віктор", "Роман", "Дмитро"
    };

    private final Random random;

    public HumanCreator(Random random) {
        this.random = random;
    }

    public Human create() {
        Sex sex = random.nextInt(2) == 0 ? Sex.MALE : Sex.FEMALE;
        String firstName = pick(sex == Sex.MALE ? MALE_NAMES : FEMALE_NAMES);
        String middleName = toMiddleName(pick(FATHER_NAMES), sex);
        return create(firstName, pickLastName(sex), middleName, sex);
    }

    public Human create(String firstName, String lastName, String middleName, Sex sex) {
        return new Human(firstName, lastName, middleName, sex);
    }

    private String pickLastName(Sex sex) {
        String lastName = pick(LAST_NAMES);
        if (sex == Sex.FEMALE && lastName.endsWith("ський")) {
            return lastName.substring(0, lastName.length() - "ський".length()) + "ська";
        }
        return lastName;
    }

    /**
     * Утворює по батькові від імені батька: Андрій → Андрійович / Андріївна, Дмитро → Дмитрович.
     */
    private String toMiddleName(String fatherName, Sex sex) {
        if (fatherName.endsWith("ій")) {
            String base = fatherName.substring(0, fatherName.length() - 1);
            return sex == Sex.MALE ? base + "йович" : base + "ївна";
        }
        String base = fatherName.endsWith("о")
                ? fatherName.substring(0, fatherName.length() - 1) : fatherName;
        return sex == Sex.MALE ? base + "ович" : base + "івна";
    }

    private String pick(String[] values) {
        return values[random.nextInt(values.length)];
    }
}
