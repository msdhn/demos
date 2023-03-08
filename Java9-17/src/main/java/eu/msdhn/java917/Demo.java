package eu.msdhn.java917;

public class Demo {
    public static void main(String... args) {

        final String b = "gh";
        var x = switch ("B") {
            case "A" -> {
                System.out.println("Parameter is A");
                yield 5;
            }
            case b -> {
                System.out.println("Parameter is b");
                yield "h";
            }
            default -> {
                System.out.println("Parameter is unknown");
                yield 1;
            }
        };

        System.out.println(x.getClass());
    }
}
