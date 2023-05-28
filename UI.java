package tracker;

public class UI {
    public Output output;
    public Action action;

    public UI(){
        output=new Output();
        action=new Action();
    }

    public void mainMenu(){
        output.titleMsg();
        while (true) {
            String userChoice = Input.readInput().strip();
            switch (userChoice) {
                case "" -> output.noInputMsg();
                case "add students" -> action.addStudents();
                case "back" -> output.errorIncorrectExitMsg();
                case "list"->action.list();
                case "add points"->action.addPoint();
                case "find"->action.find();
                case "statistics"->action.statistics();
                case "notify" ->action.accomplish();
                case "exit" -> {
                    output.byeMsg();
                    return;
                }
                default -> output.errorUnknownCommMsg();
            }
        }
    }
}
