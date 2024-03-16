public class lab3 {
    public static void main(String[] args) {
        try {
            StringBuffer sb = new StringBuffer("Пилип прилип, прилип Пилип . Пилип плаче . Пилип посіяв просо , просо поспіло , пташки прилетіли , просо поїли ."); //хотіла використати цікавіший текст, але він не підходить умовам, тому нижче залишу фрагмент з улюбленої пісня :)
            String text = sb.toString();
            System.out.println("Оригінальний текст: " + text);
            String[] words = text.split("\\s+");
            StringBuilder output = new StringBuilder();
            for (String word : words) {
                char lastLetter = word.charAt(word.length() - 1);
                String newWord = word.replaceAll(String.valueOf(lastLetter), "");
                output.append(newWord).append(" ");
            }
            System.out.println("Результат: " + output.toString().trim());
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}

//Your head is humming and it won't go
//In case you don't know
//The piper's calling you to join him

//Dear lady, can you hear the wind blow?
//And did you know
//Your stairway lies on the whispering wind?