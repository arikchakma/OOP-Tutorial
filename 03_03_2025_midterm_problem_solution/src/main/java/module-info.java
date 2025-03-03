module com.arikko.midterm_problem_solution {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.midterm_problem_solution to javafx.fxml;
    exports com.arikko.midterm_problem_solution;
}