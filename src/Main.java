import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main
{
   
    public static void main(String[] args) {

        int option;
        boolean check12;
        boolean checkAmount;
        boolean checkYN;
        boolean finish=true;
        double amount;
        double value;
        double result;
        String  yesNo;
        List results = new ArrayList();

        System.out.println("Welcome to currency converter");

        do


        /////////////////////////////////////////////////////////////////////////
        //Do - keep the loop running till the user choose to leave the program//
        ///////////////////////////////////////////////////////////////////////
            {
            System.out.println("Please choose an option (1/2)");

            do
            //////////////////////////////////////////////////////////////////////////////////////
            //Do - keep the loop running till the user will choose between the two options: 1/2//
            ////////////////////////////////////////////////////////////////////////////////////
                {
                System.out.println("\n1. Dollars to Shekels\n2. Shekels to Dollars");
                Scanner input1 = new Scanner(System.in);
                option=0;
                try
                ///////////////////////////////////////////////////////
                //Exception handler - in case the user insert String//
                /////////////////////////////////////////////////////
                {
                    option = input1.nextInt();
                }catch (InputMismatchException eIM){
                    eIM.printStackTrace();
                    }
                if
                ///////////////////////////////////////////////////////////////////////////////////////
                //If - filter the choosing to 1 or 2, in case the user insert other number or String//
                /////////////////////////////////////////////////////////////////////////////////////
                        (option==1||option==2) {
                    check12 = false;

                }
                else {
                    check12 = true;
                    System.out.println("- Invalid choice -\nPlease choose again");}
            }  while (check12==true);
            do
            ///////////////////////////////////////////////////////////////////
            //Do - keep the loop running till the user insert a valid amount//
            // prevent cases like: String or negative numbers////////////////
            ////////////////////////////////////////////////////////////////
                {
                System.out.println("Please enter an amount to convert");
                Scanner input2 = new Scanner(System.in);
                amount=0;
                try
                ///////////////////////////////////////////////////////////////
                //Exception handler - in case the user type a Char or String//
                /////////////////////////////////////////////////////////////
                {
                    amount= input2.nextDouble();
                }catch (InputMismatchException eIT){
                    eIT.printStackTrace();
                    checkAmount=true;
                }

                if
                //////////////////////////////////////////////////////////////////////////////////////////////////////////
                //If - filter the choosing to a positive number, in case the user will insert negative number or String//
                ////////////////////////////////////////////////////////////////////////////////////////////////////////
                        (amount>0){
                    checkAmount=false;
                }
                else{
                    checkAmount=true;
                    System.out.println("- Invalid choice -\nTry again");}
            }while (checkAmount==true);



            USD usd = new USD();
            ///////////////////////////////////////////////////////////
            //Creating an object from the class USD to get the value//
            /////////////////////////////////////////////////////////
            ILS ils = new ILS();
            ///////////////////////////////////////////////////////////
            //Creating an object from the class ILS to get the value//
            /////////////////////////////////////////////////////////


            if
            //////////////////////////////////////////////
            //If - check which value to get: USD or ILS//
            ////////////////////////////////////////////
                    (option==1) {
                value=usd.getValue();
            }
            else {
                value = ils.getValue();
            }

            result = value*amount;
            ///////////////////////////////
            //Calculating the conversion//
            /////////////////////////////
            System.out.println(result);
            results.add(result);
            /////////////////////////////////////
            //Add - add the result to the list//
            ///////////////////////////////////
            do
            ////////////////////////////////////////////////////////////////////////////////////////
            //Do - keep the loop running till the user choose between the two options: Y \ N//
            //////////////////////////////////////////////////////////////////////////////////////
                {
                System.out.println("Do you want to start over? (Y / N)");

            Scanner input3 = new Scanner(System.in);
            yesNo = input3.next();
            if
            ///////////////////////////////////////////////////////////
            //If - check if the user want to quit the program or not//
            /////////////////////////////////////////////////////////
                    (yesNo.equals("y")||yesNo.equals("Y")||yesNo.equals("n")||yesNo.equals("N")){

                checkYN=false;
                finish=true;

                if (yesNo.equals("n")||yesNo.equals("N")){
                    finish =false;
                    checkYN=false;
                }
            }

            else{
                checkYN=true;
                System.out.println("- Invalid choice -\nPlease choose again");}
            }while (checkYN==true);


        }while (finish==true);
        System.out.println("Your last Conversions results:\n"+results);
        System.out.println("\nThanks for using our currency converter!!");

    }

    }

