package version1.gameUtil.screens;

import version1.gameUtil.GameFrame;
import version1.gameUtil.listeners.implementations.GoToRegistrationBListener;
import version1.gameUtil.settings.UIConfigurations;
import version1.gameUtil.widgets.buttons.MazeButton;

import javax.swing.*;
import java.awt.*;

/**
 * Login Screen
 */
public class LoginScreen extends AbstractScreen{

    // The label of the header of the screen
    private JLabel headerLabel;

    // User icon on the Login Page
    private JLabel icon;

    // The login button TODO: Replace with customized button from widgets
    private JButton loginButton;

    // GoToRegister button TODO: Replace with customized button from widgets
    private JButton goToRegistrationScreenButton;


    // The username textfield label
    private JLabel userNameInputFieldLabel;

    // Username input text field TODO: Replace with customized textfield from widgets
    private JTextField userNameInputTextfield;

    public LoginScreen(GameFrame gameFrame){

        // Sets the parent frame to be gameFrame
        this.gameFrame = gameFrame;

        // Set isConfigured to false
        this.isConfigured = false;

        // Configure UI components before starting the build process
        UIConfigurations.configure(this);
    }

    /**
     * Is implemented by the child class in order to build the header of the screen
     * Creates the header
     */
    @Override
    public void buildHeader() {

        /*
         * First things first: sets the layout manager of the GameFrame
         */
        this.gameFrame.setLayout(new GridBagLayout());

        /*
         * Build the header container
         */
        final JPanel headerContainer = new JPanel();
        final Color headerContainerColor = new Color(153, 0, 153);
        headerContainer.setLayout(new FlowLayout());
        headerContainer.setBackground(headerContainerColor);
        headerContainer.add(headerLabel);
        this.add(headerContainer, BorderLayout.NORTH);
    }

    /**
     * Is implemented by the child class in order to build the body of the screen
     */
    @Override
    public void buildBody() {

        // Create the icon container
        JPanel iconContainer = new JPanel();
        iconContainer.setLayout(new BorderLayout());
        iconContainer.add(this.icon, BorderLayout.CENTER);
        this.add(iconContainer, BorderLayout.WEST);

        // Create input box Container
        JPanel inputBoxContainer = new JPanel();
        inputBoxContainer.setLayout(new GridLayout(2,1));
        inputBoxContainer.add(this.userNameInputFieldLabel);
        inputBoxContainer.add(this.userNameInputTextfield);

        // Create Button Container
        JPanel buttonsContainer = new JPanel();
        buttonsContainer.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonsContainer.add(goToRegistrationScreenButton);
        buttonsContainer.add(loginButton);

        // Creating whole form sub container
        JPanel formSubContainer = new JPanel();
        formSubContainer.setLayout(new GridLayout(2,1));
        formSubContainer.add(inputBoxContainer);
        formSubContainer.add(buttonsContainer);

        // Create whole formData container
        JPanel formContainer = new JPanel();
        formContainer.setLayout(new BorderLayout());
        formContainer.add(formSubContainer, BorderLayout.CENTER);
        this.add(formContainer, BorderLayout.CENTER);
    }

    /**
     * Creates a Label for the header
     * @param headerLabelText : Label Text
     * @param font : Label text font
     * @param textColor : Label text color
     * @return this
     */
    public LoginScreen setHeaderLabel(String headerLabelText, Font font, Color textColor) {
        this.headerLabel = new JLabel(headerLabelText);
        this.headerLabel.setFont(font);
        this.headerLabel.setForeground(textColor);
        return this;
    }

    public LoginScreen setIcon(ImageIcon icon) {
        this.icon = new JLabel(icon);
        return this;
    }

    /**
     *  Creates the Login Button
     * @param label : The label of the button
     * @return this
     */
    public LoginScreen createLoginButton(String label) {
        /*
         * TODO: Add logic to go to Menu Screen here  | Nicole
         */
        this.loginButton = new JButton(label);
        return this;
    }

    /**
     * Creates an action listener for registration screen button
     */
    public LoginScreen createGoToRegistrationScreenButton(String label) {
        this.goToRegistrationScreenButton = new MazeButton(label, new GoToRegistrationBListener(gameFrame));
        return this;
    }


    public LoginScreen createUserNameInputFieldMaxLength(int maxLength) {
        this.userNameInputTextfield = new JTextField(maxLength);
        return this;
    }


    public LoginScreen setUserNameInputFieldLabel(String userNameInputFieldLabelText) {
        this.userNameInputFieldLabel = new JLabel(userNameInputFieldLabelText);
        return this;
    }

    /**
     * Checks if all the UI components (i.e attributes) have been properly
     * configured by the UIConfigurations.configure() method.
     *
     * This guarantees that the buildHeader() buildBody() will work with
     * non null objects.
     */
    @Override
    public void ready(){
        /*
            TODO: Create Exception Handling classes to avoid hardcoding stiff like this
            Low priority at the moment
         */
        final String headerLabelErrorMsg = "LoginScreen.headerLabel cannot be null";
        final String iconErrorMsg = "LoginScreen.icon cannot be null";
        final String loginButtonErrorMsg = "LoginScreen.loginButton cannot be null";
        final String goToRegistrationScreenButtonErrorMsg = "LoginScreen.goToRegistrationScreenButton cannot be null";
        final String userNameInputFieldLabelErrorMsg = "LoginScreen.userNameInputFieldLabel cannot be null";
        final String userNameInputTextfieldErrorMsg = "LoginScreen.userNameInputTextfield cannot be null";

        try{
            if(this.headerLabel == null) {
                throw new Exception(headerLabelErrorMsg);
            }

            if(this.icon == null)
                throw new Exception(iconErrorMsg);

            if(this.loginButton == null)
                throw new Exception(loginButtonErrorMsg);

            if(this.goToRegistrationScreenButton == null)
                throw new Exception(goToRegistrationScreenButtonErrorMsg);

            if(this.userNameInputFieldLabel == null)
                throw new Exception(userNameInputFieldLabelErrorMsg);

            if(this.userNameInputTextfield == null)
                throw new Exception(userNameInputTextfieldErrorMsg);

            // If none of the above thre an Exception then everything is good
            this.isConfigured = true;

        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
