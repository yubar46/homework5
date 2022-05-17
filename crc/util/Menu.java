package util;

import domain.*;
import repository.ProductRepositoryJDBC;
import repository.ProductTypeRepository;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {

    Scanner inputNumber = new Scanner(System.in);
    Scanner inputString = new Scanner(System.in);
    ApplicationContext applicationContext =new ApplicationContext();
    boolean exit = false;

    public Menu() throws SQLException, ClassNotFoundException {
    }

        public void showFirstMenu(){
        System.out.printf("%s %n %s %n %s %n %s %n ","welcome to homework5 market"
                ,"for login enter 1 ","for sign up enter 2","for exit enter-1");




    }

        public int customerSelect(){
            int customerSelect = inputNumber.nextInt();

                return customerSelect;
        }


        public int  cheekSelect(int customerSelect){
               int correctSelect = 0 ;
               while (correctSelect==0){
                   if (customerSelect==1||customerSelect==2||customerSelect==-1){
                       correctSelect=customerSelect;
                   }else {
                       System.out.println("wrong number try again");
                       showFirstMenu();
                       customerSelect();
                   }

               }
                return correctSelect;
        }



        public void enterMenu(int select) throws SQLException {



             if (select==1){
                applicationContext.setUser(login());
                insideMenu(applicationContext.getUser());

            } if (select==2){
               applicationContext.setUser(singUp());
               insideMenu(applicationContext.getUser());

            }


            if (select==-1) {
                System.out.println("goodbye");
                exit =true;
            }

        }

    private void insideMenu(User user) throws SQLException {
        System.out.printf("  %s %n %s %n %s %n","for view products enter 1 "
                ,"for view your cart enter2 ","for exit enter-1");
             int select= customerSelect();
        if (select==1){
            applicationContext.getProductTypeRepository().readAllProductTypes();
            System.out.println("please select productType");
            int productType = inputNumber.nextInt();
            applicationContext.getProductRepository().showAllProducts(productType);
            System.out.println("for add product to your card enter 1");
            System.out.println("for view your cart enter 2 ");
            System.out.println("for view another product type enter3  ");
            System.out.println("for exit enter -1");
            int choice = inputNumber.nextInt();

            if (choice==1){
                System.out.println("enter product id");
                int productId = inputNumber.nextByte();

               Product product = applicationContext.getProductRepository().selectProduct(productId);
                boolean exist = false;
               do {
                   System.out.println("enter number of product");
                   int nOfProduct = inputNumber.nextInt();
                   product.setNumber(nOfProduct);
                     exist = applicationContext.getProductRepository().isExist(product);
                     if (!exist){
                         System.out.println("item is not enough exist choice number again");
                     }
               }while (exist =false);
                Cart cart =new Cart();
                if (cart.getProducts().size()>5){
                    cart.setProducts(product);
                    cart.setUserId(user.getId());
                    cart.calculateItemPrice();

                        int id= applicationContext.getCartRepository().addToCart(cart);
                        cart.setId(id);
                    applicationContext.setCart(cart);


                }else System.out.println("cart is full");


            }if (choice==2){
                applicationContext.getCartRepository().viewCart(applicationContext.getCart().getUserId());
                System.out.println("for delete order from cart enter 1");
                System.out.println("Finalize the shopping cart enter 2");
                int cartChoice = inputNumber.nextInt();
                if (cartChoice==1){
                    System.out.println("enter cart id");
                    int cartId = inputNumber.nextInt();
                applicationContext.getCartRepository().deleteFromCart(cartId);
                applicationContext.getCart().calculateItemPrice();
                applicationContext.getCartRepository().addToCart(applicationContext.getCart());
                }
                if (cartChoice==2){
                    if (user.getAddresses().isEmpty()){
                        System.out.println("please enter your State");
                        String state = inputString.next();
                        System.out.println("please enter your city");
                        String city = inputString.next();
                        System.out.println("please enter your street name");
                        String streetName = inputString.next();
                        System.out.println("please enter your pistol code");
                        String pistolCode = inputString.next();
                        Address address = new Address(state,city,streetName,pistolCode);
                        address.setUserId(user.getId());
                        int addressId = applicationContext.getAddressRepository().addAddress(address);
                        address.setId(addressId);
                        user.setAddresses(address);

                    }else{

                        applicationContext.getAddressRepository().readAddress(user.getId());
                        System.out.println("please enter address id");
                        int addressId = inputNumber.nextInt();
                        PastOrders pastOrders = new PastOrders();
                        Address address =new Address() ;
                            for (int i = 0 ; i<user.getAddresses().size();i++){
                                if (user.getAddresses().get(i).getId()==addressId){
                                        address =(user.getAddresses().get(i));

                                }
                            }
                            for (int i = 0; i< applicationContext.getCart().getProducts().size();i++){
                                pastOrders.setProduct(applicationContext.getCart().getProducts().get(i));
                                pastOrders.setPrice(applicationContext.getCart().getProducts().get(i).getPrice());
                                pastOrders.setUserID(user.getId());
                                user.getPastOrders().add(pastOrders);
                                applicationContext.getPastOrdersRepository().AddToPastOrders(pastOrders);
                               // applicationContext.getProductRepository().editProduct(pastOrders.getProduct(),
                                 //       ( pastOrders.getProduct().getNumber()));

                            }



                    }

                }

            }

        }




    }

        public User singUp() throws SQLException {
        String validUserName;
        String userName;
        do {
            System.out.println("please enter your user name");
            userName = inputString.next();


        }while (!applicationContext.getUserRepository().validUser(userName));
            String password = cheekPassword();
            System.out.println("please enter your first Name");
            String firstName = inputString.nextLine();
            System.out.println("please enter your last Name");
            String lastName = inputString.nextLine();
                    String phoneNumber= cheekPhoneNumber();
                    String email = cheekEmail();

                    User user = new User(userName,password,firstName,lastName,phoneNumber,email);

                    int userId = applicationContext.getUserRepository().addUser(user);
                    user.setId(userId);
                    return user;





        }
            public User login() throws SQLException {
                boolean cheekLogin = false;
                User user;
                String username;
                String password;
                int userId =-1;
                while (!cheekLogin){
                    System.out.println("please enter your username ");
                     username = inputString.next();
                    System.out.println("please enter your password");
                     password =inputString.next();
                     userId = cheekLogin(username,password);
                     if (userId!=-1)cheekLogin=true;
                }
                user = applicationContext.getUserRepository().readUser(userId);
                return user;





            }


        private String cheekPassword(){

            String cheekedPassword ="";
            String password1 = "";
            do {
                System.out.println("please enter your password");
                password1 =inputString.next();
                System.out.println("please enter your password");
                String password2 =inputString.next();
                if (password1.equals(password2))cheekedPassword=password1;

            } while (!cheekedPassword.equals(password1));
            return cheekedPassword;
        }
        private String cheekPhoneNumber() throws SQLException {
            String phoneNumber = null;
            while (phoneNumber==null){
                System.out.println("please enter your phone number");
                String pNumber = inputString.next();

                if (!applicationContext.getUserRepository().validPhoneNumber(pNumber))phoneNumber=pNumber;

            }
            return phoneNumber;

        }

        private String cheekEmail() throws SQLException {
            String email = null;
            while (email==null){
                System.out.println("'please enter your email");
                String inputEmail = inputString.next();

                if (!applicationContext.getUserRepository().validEmail(inputEmail))email=inputEmail;

            }
            return email;
        }

        private int cheekLogin(String username,String password) throws SQLException {
        return applicationContext.getUserRepository().cheekLogin(username,password);

        }









    //مشاهده ی سبد خرید

    // با مشاهده ی سبد خرید می توان محصولات داخل سبد رو دیلیت کرد
    // داخل منو سبد خرید میتوان لیست محصولات را انتخاب کرد

    //مشاهده ی محصولات سفارش یافته در گذشته
    //اضافه کردن محصولات به سبد خرید
    //تایید نهایی خرید که برابر است با کم شدن محصولات انتخاب شده از موجودی انبار
    //خروج


}
