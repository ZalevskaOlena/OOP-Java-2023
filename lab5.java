class Character {
    private char value;

    public Character(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }
}

class Word {
    private Character[] characters;

    public Word(Character[] characters) {
        this.characters = characters;
    }

    public String getStringValue() {
        StringBuilder sb = new StringBuilder();
        for (Character character : characters) {
            sb.append(character.getValue());
        }
        return sb.toString();
    }
}

class Sentence {
    private Word[] words;
    private Character[] punctuationMarks;

    public Sentence(Word[] words, Character[] punctuationMarks) {
        this.words = words;
        this.punctuationMarks = punctuationMarks;
    }

    public String getStringValue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            sb.append(words[i].getStringValue());
            if (i < punctuationMarks.length) {
                sb.append(punctuationMarks[i].getValue());
            }
            sb.append(" ");
        }
        return sb.toString();
    }
}

class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public String getStringValue() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            sb.append(sentences[i].getStringValue());
        }
        return sb.toString();
    }
}

public class lab5 {
    public static void main(String[] args) {
        try {
            Character[] characters = {new Character('Ш'), new Character('а'), new Character('н'), new Character('о'), new Character('в'), new Character('н'), new Character('і')};
            Word word = new Word(characters);
            System.out.println("Слово: " + word.getStringValue());

            Character[] punctuationMarks = {new Character(','), new Character('!')};
            Word[] words = {word};
            Sentence sentence = new Sentence(words, punctuationMarks);
            System.out.println("Речення: " + sentence.getStringValue());

            Sentence[] sentences = {sentence};
            Text text = new Text(sentences);
            System.out.println("Текст: " + text.getStringValue());
        } catch (Exception e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
