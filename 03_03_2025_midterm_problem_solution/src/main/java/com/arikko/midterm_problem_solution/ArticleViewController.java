package com.arikko.midterm_problem_solution;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;
import java.util.ArrayList;

public class ArticleViewController {
    @javafx.fxml.FXML
    private TextField titleTextField;
    @javafx.fxml.FXML
    private TextField startYearTextField;
    @javafx.fxml.FXML
    private ComboBox<String> articleTypeComboBox;
    @javafx.fxml.FXML
    private TextField nameOfTheFirstAuthorTextField;
    @javafx.fxml.FXML
    private ComboBox<String> filterArticleTypeComboBox;
    @javafx.fxml.FXML
    private TextArea highestNumberOfAuthorsTextArea;
    @javafx.fxml.FXML
    private DatePicker publicationDateDatePicker;
    @javafx.fxml.FXML
    private TextField numberOfAuthorsTextField;
    @javafx.fxml.FXML
    private CheckBox citationStatusCheckBox;
    @javafx.fxml.FXML
    private CheckBox filterCitationStatusCheckBox;
    @javafx.fxml.FXML
    private TextField endYeatTextField;

    private ArrayList<Article> articleList;
    @javafx.fxml.FXML
    private Label messageLabel;
    @javafx.fxml.FXML
    private TableColumn<Article, Integer> noOfAuthorsCol;
    @javafx.fxml.FXML
    private TableView<Article> articlesTableView;
    @javafx.fxml.FXML
    private TableColumn<Article, String> titleCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> articleTypeCol;
    @javafx.fxml.FXML
    private TableColumn<Article, LocalDate> publicationDateCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> citationStatusCol;
    @javafx.fxml.FXML
    private TableColumn<Article, String> authorNameCol;

    @javafx.fxml.FXML
    public void initialize() {
        articleList = new ArrayList<Article>();

        articleTypeComboBox.getItems().add("Review");
        articleTypeComboBox.getItems().add("Book");
        articleTypeComboBox.getItems().add("Case");

        filterArticleTypeComboBox.getItems().add("Review");
        filterArticleTypeComboBox.getItems().add("Book");
        filterArticleTypeComboBox.getItems().add("Case");

        titleCol.setCellValueFactory(new PropertyValueFactory<Article, String>("title"));
        authorNameCol.setCellValueFactory(new PropertyValueFactory<Article, String>("author"));
        articleTypeCol.setCellValueFactory(new PropertyValueFactory<Article, String>("articleType"));
        citationStatusCol.setCellValueFactory(new PropertyValueFactory<Article, String>("citationStatus"));
        noOfAuthorsCol.setCellValueFactory(new PropertyValueFactory<Article, Integer>("numberOfAuthors"));
        publicationDateCol.setCellValueFactory(new PropertyValueFactory<Article, LocalDate>("publicationDate"));
    }

    @javafx.fxml.FXML
    public void yearFilterOnAction(ActionEvent actionEvent) {
        int start_year = Integer.parseInt(startYearTextField.getText());
        int end_year = Integer.parseInt(endYeatTextField.getText());

        articlesTableView.getItems().clear();

        for (Article a : articleList) {
            if (a.getPublicationDate().getYear() >= start_year && a.getPublicationDate().getYear() <= end_year) {
                articlesTableView.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void addArticleButtonMouseOnClicked(ActionEvent actionEvent) {
        messageLabel.setText("");

        String title = titleTextField.getText();
        boolean is_unique_title = true;
        for (Article a : articleList) {
            if (a.getTitle().equals(title)) {
                is_unique_title = false;
                break;
            }
        }

        if (!is_unique_title) {
            messageLabel.setText("Title must be unique");
            return;
        }

        String authorName = nameOfTheFirstAuthorTextField.getText();
        String articleType = articleTypeComboBox.getValue();
        LocalDate publicationDate = publicationDateDatePicker.getValue();
        int numberOfAuthors = Integer.parseInt(numberOfAuthorsTextField.getText());

        String citationStatus = "No";
        if (citationStatusCheckBox.isSelected()) {
            citationStatus = "Yes";
        }

        Article new_article = new Article(title, authorName, articleType, citationStatus, numberOfAuthors, publicationDate);
        articleList.add(new_article);
        articlesTableView.getItems().add(new_article);

        titleTextField.clear();
        nameOfTheFirstAuthorTextField.clear();
        numberOfAuthorsTextField.clear();
        citationStatusCheckBox.setSelected(false);
        publicationDateDatePicker.setValue(null);
        messageLabel.setText("Successfully inserted an Article!!");
    }

    @javafx.fxml.FXML
    public void searchArticleOnAction(ActionEvent actionEvent) {
        articlesTableView.getItems().clear();

        String articleType = filterArticleTypeComboBox.getValue();
        String citationStatus = "No";
        if (filterCitationStatusCheckBox.isSelected()) {
            citationStatus = "Yes";
        }

        for (Article a : articleList) {
            if (a.getArticleType().equals(articleType) && a.getCitationStatus().equals(citationStatus)) {
                articlesTableView.getItems().add(a);
            }
        }
    }

    @javafx.fxml.FXML
    public void showArticleWithHighestAuthorButtonMouseOnClicked(ActionEvent event) {
        int highest_no_of_authors = -1;
        for (Article a : articleList) {
            // it means the highest_no_of_authors variable value is smaller than
            // the current(a) article number of authors
            if (highest_no_of_authors < a.getNumberOfAuthors()) {
                highest_no_of_authors = a.getNumberOfAuthors();
            }
        }

        if (highest_no_of_authors == -1) {
            messageLabel.setText("No Articles");
            return;
        }

        String articles = "";
        for (Article a : articleList) {
            if (a.getNumberOfAuthors() == highest_no_of_authors) {
                articles += a.toString() + "\n\n";
            }
        }

        highestNumberOfAuthorsTextArea.setText(articles);
    }
}