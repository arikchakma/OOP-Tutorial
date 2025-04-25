module com.arikko.prev_final_exam_solution {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.arikko.prev_final_exam_solution to javafx.fxml;
    exports com.arikko.prev_final_exam_solution;
}