import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene; 
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.SplitPane; 
import javafx.scene.text.TextAlignment;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;
import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.KeyValue;
import javafx.scene.text.Font;
import javafx.scene.layout.StackPane;
import java.lang.Math;
import javafx.scene.Node;
import java.util.ArrayList;
/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Display extends Application{
    /**
     * Constructor for objects of class Game
     */
    @Override
    public void start(Stage stage){

        //Group root = new Group();
        //Scene scene = new Scene(root);
        //scene.setFill(Color.RED);

        stage.setTitle("RWBY Emblem");
        stage.setScene(splashScreen(stage)); 
        stage.show(); 
        //root.getChildren().add(mainPain);

        //for(){
        //main game
        //}
    }

    public Scene splashScreen(Stage stage){
        //SPLASH SCREEN
        File file = new File("day.wav");
        String MEDIA_URL = file.toURI().toString();
        Media bga1 = new Media(MEDIA_URL);
        MediaPlayer splashBGM = new MediaPlayer(bga1);
        splashBGM.setVolume(.7);
        splashBGM.setStartTime(Duration.ZERO);
        splashBGM.setAutoPlay(true);
        splashBGM.setOnEndOfMedia(new Runnable() 
            {
                public void run() {
                    splashBGM.seek(Duration.ZERO);
                }
            }
        );
        splashBGM.play();

        AnchorPane splashPane = new AnchorPane();
        ImageView splashView = new ImageView();
        Image splashSil = new Image("bg_with_text.png", 1280, 720, true, false);
        Image splashR = new Image("bg_ruby.png", 1280, 720, true, false);
        ImageView splashRV = new ImageView();
        splashRV.setImage(splashR);
        splashRV.setOpacity(0.0);
        Image splashW = new Image("bg_weiss.png", 1280, 720, true, false);
        ImageView splashWV = new ImageView();
        splashWV.setImage(splashW);
        splashWV.setOpacity(0.0);
        Image splashB = new Image("bg_blake.png", 1280, 720, true, false);
        ImageView splashBV = new ImageView();
        splashBV.setImage(splashB);
        splashBV.setOpacity(0.0);
        Image splashY = new Image("bg_yang.png", 1280, 720, true, false);
        ImageView splashYV = new ImageView();
        splashYV.setImage(splashY);
        splashYV.setOpacity(0.0);
        splashView.setImage(splashSil);
        splashPane.getChildren().add(splashView);
        splashPane.setRightAnchor(splashView, 0.0);
        splashPane.setLeftAnchor(splashView, 0.0);
        splashPane.setTopAnchor(splashView, 0.0);
        splashPane.setBottomAnchor(splashView, 0.0);
        MediaView splashMView = new MediaView(splashBGM);
        splashMView.setVisible(false);
        splashPane.getChildren().add(splashMView);

        HBox splashButtonBox = new HBox();
        splashPane.getChildren().add(splashButtonBox);
        splashPane.setBottomAnchor(splashButtonBox, 0.0);

        Image menuIcon1 = new Image("ruby_emblem.png", 280, 280, true, false);
        ImageView menuV1 = new ImageView(menuIcon1);

        Image menuIcon2 = new Image("weiss_emblem.png", 280, 280, true, false);
        ImageView menuV2 = new ImageView(menuIcon2);

        Image menuIcon3 = new Image("blake_emblem.png", 280, 280, true, false);
        ImageView menuV3 = new ImageView(menuIcon3);

        Image menuIcon4 = new Image("yang_emblem.png", 280, 280, true, false);
        ImageView menuV4 = new ImageView(menuIcon4);

        Font font = new Font(20.0);
        font.font("Lucida Calligraphy", 20.0);
        Button menu1 = new Button();
        menu1.setPrefSize(280, 280);
        menu1.setOpacity(0.0);
        Label l1 = new Label("PLAY GAME");
        l1.setPrefSize(280, 280);
        l1.setFont(new Font("Arial", 30));
        menu1.setOnAction(e->
            {
                fadeMusic(splashBGM);
                stage.setScene(mapScreen(stage));
            }
        );
        StackPane m1 = new StackPane();
        m1.setPrefSize(280, 280);
        m1.getChildren().addAll(menuV1, l1, menu1);
        StackPane m2 = new StackPane();
        Button menu2 = new Button();
        menu2.setPrefSize(280, 280);
        menu2.setOpacity(0.0);
        Label l2 = new Label("HOW TO PLAY");
        l2.setPrefSize(280, 280);
        l2.setFont(font);
        l2.setTextFill(Color.RED);
        m2.setPrefSize(280, 280);
        m2.getChildren().addAll(menuV2, l2, menu2);
        StackPane m3 = new StackPane();
        Button menu3 = new Button();
        menu3.setPrefSize(280, 280);
        menu3.setOpacity(0.0);
        Label l3 = new Label("CREDITS");
        l3.setPrefSize(280, 280);
        l3.setFont(new Font(20));
        m3.setPrefSize(280, 280);
        m3.getChildren().addAll(menuV3, l3, menu3);
        StackPane m4 = new StackPane();
        Button menu4 = new Button();
        menu4.setPrefSize(280, 280);
        menu4.setOpacity(0.0);
        Label l4 = new Label("QUIT GAME");
        l4.setPrefSize(280, 280);
        l4.setFont(new Font(20));
        m4.setPrefSize(280, 280);
        m4.getChildren().addAll(menuV4, l4, menu4);
        //         Button menu2 = new Button("How to Play", menuV2);
        //         menu2.setPrefSize(280, 280);
        //         menu2.setOpacity(.5);
        //         Button menu3 = new Button("Credits", menuV3);
        //         menu3.setPrefSize(280, 280);
        //         Button menu4 = new Button("Quit Game", menuV4);
        //         menu4.setPrefSize(280, 280);
        l1.setAlignment(Pos.CENTER);
        l2.setAlignment(Pos.CENTER);
        l3.setAlignment(Pos.CENTER);
        l4.setAlignment(Pos.CENTER);
        //splashButtonBox.getChildren().addAll(menu1, menu2, menu3, menu4);
        splashButtonBox.getChildren().addAll(m1, m2, m3, m4);

        Scene sceneSplash = new Scene(splashPane, 1280, 720);
        return sceneSplash;
    }

    public void fadeMusic(MediaPlayer player){
        Timeline timeline = new Timeline(
                new KeyFrame(new Duration(1500), new KeyValue(player.volumeProperty(), 0.0)));
        timeline.play();
    }

    public Scene mapScreen(Stage stage){
        BorderPane mainPain = new BorderPane();
        SplitPane splitLeft = new SplitPane();
        splitLeft.setOrientation(Orientation.VERTICAL);
        ImageView leftview = new ImageView();
        Image leftmug = new Image("ruby_emblem.png", 160, 160, true, false);
        leftview.setImage(leftmug);
        splitLeft.getItems().add(leftview);
        VBox lvbox = new VBox();
        Label leftname = new Label("");
        Label leftwep  = new Label("Weapon:");
        Label leftHP = new Label("Health:");
        lvbox.setAlignment(Pos.TOP_CENTER);
        lvbox.getChildren().add(leftname); //ad a listener?
        lvbox.getChildren().add(leftwep); // ^^ same?????
        lvbox.getChildren().add(leftHP);
        splitLeft.getItems().add(lvbox);
        HBox leftH = new HBox();
        VBox leftHV1 = new VBox();
        leftHV1.setAlignment(Pos.CENTER_LEFT);
        VBox leftHV2 = new VBox();
        leftHV1.getChildren().addAll(new Label("Strength:"), new Label("Magic"), new Label("Skill:"),
            new Label("Speed:"), new Label("Luck:"), new Label("Defense:"), new Label("Resistance:"));
        leftHV2.setAlignment(Pos.CENTER_RIGHT);
        leftH.getChildren().add(leftHV1);
        leftH.getChildren().add(leftHV2);
        Label lstr = new Label("");
        Label lmag = new Label("");
        Label lskl = new Label("");
        Label lspd = new Label("");
        Label llck = new Label("");
        Label ldef = new Label("");
        Label lres = new Label("");
        leftHV2.getChildren().addAll(lstr, lmag, lskl, lspd, llck, ldef, lres);
        //         leftHV1.getChildren().addAll(lstr, lmag, lskl, lspd, llck, ldef, lres);
        //         Label leftStrength = new Label("");
        //         Label leftMagic = new Label("");
        //         Label leftSkill = new Label("");
        //         Label leftSpeed = new Label("");
        //         Label leftLuck = new Label("");
        //         Label leftDefense = new Label("");
        //         Label leftResistance = new Label("");
        //         leftHV2.getChildren().addAll(leftStrength, leftMagic, leftSkill, leftSpeed, leftLuck, 
        //leftDefense, leftResistance);
        lvbox.getChildren().add(leftH);

        SplitPane splitRight = new SplitPane();
        splitRight.setOrientation(Orientation.VERTICAL);
        ImageView rightview = new ImageView();
        Image rightmug = new Image("jaune_emblem.png", 160, 160, true, false);
        rightview.setImage(rightmug);
        splitRight.getItems().add(rightview);
        VBox rvbox = new VBox();
        Label rightname = new Label("");
        Label rightwep  = new Label("Weapon: ");
        Label rightHP = new Label("Health: ");
        rvbox.getChildren().add(rightname); //ad a listener?
        rvbox.getChildren().add(rightwep); // ^^ same?????
        rvbox.getChildren().add(rightHP);
        rvbox.setAlignment(Pos.TOP_CENTER);
        splitRight.getItems().add(rvbox);
        HBox rightH = new HBox();
        VBox rightHV1 = new VBox();
        rightHV1.setAlignment(Pos.CENTER_LEFT);
        VBox rightHV2 = new VBox();
        rightHV2.setAlignment(Pos.CENTER_RIGHT);
        rightH.getChildren().add(rightHV1);
        rightH.getChildren().add(rightHV2);
        rightHV1.getChildren().addAll(new Label("Strength:"), new Label("Magic"), new Label("Skill:"),
            new Label("Speed:"), new Label("Luck:"), new Label("Defense:"), new Label("Resistance:"));
        Label rstr = new Label("");
        Label rmag = new Label("");
        Label rskl = new Label("");
        Label rspd = new Label("");
        Label rlck = new Label("");
        Label rdef = new Label("");
        Label rres = new Label("");
        rightHV2.getChildren().addAll(rstr, rmag, rskl, rspd, rlck, rdef, rres);
        rvbox.getChildren().add(rightH);

        mainPain.setLeft(splitLeft);
        mainPain.setRight(splitRight);

        Image rEmblem = new Image("ruby_emblem.png", 160, 160, true, false);

        Board board = new Board(8, 6);
        Weapon crro = new Weapon(10, 80, 7, 5, true, true, "Crescent Rose");
        Image r = new Image ("ruby_rose.png");
        Unit ruby = new Unit(r, 30, 6, 1, 14, 8, 14, 16, 9, 13, 11, 2, crro, "Ruby Rose", 0);
        board.setTile(ruby.getXPos(), ruby.getYPos(), ruby);
        ImageView rubyView = new ImageView();
        Image rubyMapSprite = new Image("ruby_emblem.png", 90, 90, true, false);
        rubyView.setImage(rubyMapSprite);
        board.placeUnit(ruby);
        ruby.setMapView(rubyView);

        Weapon myrt = new Weapon(7, 90, 4, 15, true, true, "Myrtenaster");
        Image w = new Image("weiss_schnee.png");
        Unit weiss = new Unit(w, 24, 6, 0, 9, 14, 18, 10, 6, 8, 16, 2, myrt, "Weiss Schnee", 0); //83
        board.setTile(weiss.getXPos(), weiss.getYPos(), weiss);
        ImageView weissView = new ImageView();
        Image weissMapSprite = new Image("weiss_emblem.png", 90, 90, true, false);
        weissView.setImage(weissMapSprite);
        weiss.setMapView(weissView);

        board.placeUnit(weiss);

        Weapon gash = new Weapon(10, 85, 3, 10, true, true, "Gambol Shroud");
        Image bl = new Image("blake_belladonna.png");
        Unit blake = new Unit(bl, 32, 7, 1, 12, 12, 20, 20, 2, 10, 5, 2, gash, "Blake Belladonna", 0); //83
        ImageView blakeView = new ImageView();
        Image blakeMapSprite = new Image("blake_emblem.png", 90, 90, true, false);
        blakeView.setImage(blakeMapSprite);
        blake.setMapView(blakeView);

        board.placeUnit(blake);

        Weapon emce = new Weapon(15, 75, 9, 3, true, true, "Ember Celica");
        Image y = new Image("yang_xiao_long.png");
        Unit yang = new Unit(y, 40, 7, 0, 18, 2, 14, 5, 5, 20, 4, 2, emce, "Yang Xiao Long", 0); //70
        ImageView yangView = new ImageView();
        Image yangMapSprite = new Image("yang_emblem.png", 90, 90, true, false);
        yangView.setImage(yangMapSprite);
        yang.setMapView(yangView);
        board.placeUnit(yang);
        
        Weapon crmo = new Weapon(5, 50, 0, 4, true, true, "Crocea Mors");
        Image ja = new Image("jaune_mug.png");
        Unit jaune = new Unit(ja, 20, 1, 4, 10, 2, 10, 5, 5, 15, 3, 2, crmo, "Jaune Arc", 1); //70
        ImageView jauneView = new ImageView();
        Image jauneMapSprite = new Image("jaune_emblem.png", 90, 90, true, false);
        jauneView.setImage(jauneMapSprite);
        jaune.setMapView(jauneView);
        board.placeUnit(jaune);

        Weapon magn = new Weapon(15, 70, 4, 6, true, true, "Magnhild");
        Image n = new Image("nora_mug.png");
        Unit nora = new Unit(n, 30, 0, 3, 20, 5, 8, 6, 6, 15, 3, 2, magn, "Nora Valkyrie", 1); //70
        ImageView noraView = new ImageView();
        Image noraMapSprite = new Image("nora_emblem.png", 90, 90, true, false);
        noraView.setImage(noraMapSprite);
        nora.setMapView(noraView);
        board.placeUnit(nora);

        Weapon stfl = new Weapon(10, 90, 8, 2, true, true, "Stormflower");
        Image re = new Image("ren_mug.png");
        Unit ren = new Unit(re, 30, 0, 4, 20, 5, 8, 6, 6, 15, 3, 2, stfl, "Lie Ren", 1); //70
        ImageView renView = new ImageView();
        Image renMapSprite = new Image("ren_emblem.png", 90, 90, true, false);
        renView.setImage(renMapSprite);
        ren.setMapView(renView);
        board.placeUnit(ren);

        Weapon miak = new Weapon(13, 99, 4, 5, true, true, "Miló and Akoúo");
        Image p = new Image("pyrrha_mug.png");
        Unit pyrrha = new Unit(p, 30, 1, 3, 16, 5, 12, 10, 10, 17, 5, 2, miak, "Pyrrha Nikos", 1); //70
        ImageView pyrrhaView = new ImageView();
        Image pyrrhaMapSprite = new Image("pyrrha_emblem.png", 90, 90, true, false);
        pyrrhaView.setImage(pyrrhaMapSprite);
        pyrrha.setMapView(pyrrhaView);
        board.placeUnit(pyrrha);

        AnchorPane mapPain = new AnchorPane();
        ImageView mapView = new ImageView();
        Image map = new Image("Map_1.png");
        mapView.setImage(map);
        mapPain.getChildren().add(mapView);
        mapPain.setRightAnchor(mapView, 0.0);
        mapPain.setLeftAnchor(mapView, 0.0);
        mapPain.setTopAnchor(mapView, 0.0);
        mapPain.setBottomAnchor(mapView, 0.0);
        GridPane mapGrid = new GridPane();
        //StackPane[][] stacks = new StackPane[8][6];
        Button[][] buttons = new Button[8][6];

        board.setTile(ruby.getXPos(), ruby.getYPos(), ruby);
        board.setTile(weiss.getXPos(), weiss.getYPos(), weiss);

        //ADD UNITS TO BOARD HERE
        for (int i=1; i<=8; i++){
            for (int j=1; j<=6; j++){

                Button b = new Button();

                //StackPane stackTile = new StackPane();
                b.setMinSize(90, 90);
                b.setOpacity(0.0);
                mapGrid.add(b, j-1, i-1);
                buttons[i-1][j-1]=b;
                if (board.isUnit(i-1, j-1)){
                    b.setGraphic(board.getUnit(i-1, j-1).getMapView());
                    b.setOpacity(.4);
                    if (board.getType(i-1, j-1)==0){
                        b.setStyle("-fx-background-color: #4286f4; ");
                    }
                    if (board.getType(i-1, j-1)==1){
                        b.setStyle("-fx-background-color: #822828; ");
                    }
                }
                //mapGrid.add(stackTile, j-1, i-1);
                //stacks[i-1][j-1]=stackTile;
                //stackTile.getChildren().add(b);
                //                 for (Node child: mapGrid.getChildren()){
                //                     System.out.println(buttons[mapGrid.getRowIndex(b)][mapGrid.getColumnIndex(b)]);
                // 
                //                 }
                b.setOnAction(e-> 
                    {
                        //check the type of the space selected
                        //if type 3 empty
                        //if type 0
                        //if type 1
                        //if type 2, selected unit of player type 1
                        if (board.anySelected()){
                            if (board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==3){
                                board.getSelectedUnit().move(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b), board);
                                //buttons[board.getSelectedUnit().getXPos()][board.getSelectedUnit().getYPos()].setImage();
                                b.setGraphic(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getMapView());
                                //                                 Timeline timeline = new Timeline(
                                //                                         new KeyFrame(new Duration(1000), new KeyValue(mapGrid.t, 0.0)));
                                //                                 timeline.play();
                                //^^ possible animation for moving the unit (sliding)
                                ArrayList<Unit> attackOptions = board.checkOptions(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b));
                                if (attackOptions.size()>0) {System.out.println("displaying gui"); attackGUI(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)), attackOptions);}
                                board.getSelectedUnit().wait(board);
                                board.refreshBoard(buttons);
                            }
                            if (board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==1){

                                ArrayList<Unit> attackOptions = board.checkOptions(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b));
                                attackGUI(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)), attackOptions);
                            }
                        }
                        else {
                            if (board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==0){
                                board.setActive(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)));
                                setSidePanel(board.getSelectedUnit(), leftview, leftname, leftwep, leftHP, lstr, lmag, lskl, lspd, llck, ldef, lres);
                                showRange(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getWeapon().isMelee(), 
                                    board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getWeapon().isRanged(),
                                    board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getStats().get("MOV"), mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b), board, buttons, mapGrid);
                            }
                            else {
                                if (board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==1){
                                    if (board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).rangeShown()){
                                        board.unshowEnemyRange(buttons);
                                        board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).setRangeShown(false);
                                    }
                                    else{
                                        showEnemyRange(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getWeapon().isMelee(), 
                                            board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getWeapon().isRanged(),
                                            board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).getStats().get("MOV"), mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b), board, buttons, mapGrid);
                                        board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)).setRangeShown(true);
                                        setSidePanel(board.getUnit(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b)), rightview, rightname, rightwep, rightHP, rstr, rmag, rskl, rspd, rlck, rdef, rres);
                                    }
                                }
                            }
                        }
                    }
                );
            }
        }
        mapGrid.setGridLinesVisible(true);
        mapPain.setRightAnchor(mapGrid, 0.0);
        mapPain.setLeftAnchor(mapGrid, 0.0);
        mapPain.setTopAnchor(mapGrid, 0.0);
        mapPain.setBottomAnchor(mapGrid, 0.0);
        mapPain.getChildren().add(mapGrid);
        mainPain.setCenter(mapPain);

        //         rubyView.setImage(rubyMapSprite);
        //         rubyView.setX(160+90*ruby.getXPos());
        //         rubyView.setY(90*ruby.getYPos());

        Scene sceneMap = new Scene(mainPain, 860, 720);
        return sceneMap;
    }

    public void showRange(boolean isMelee, boolean isRanged, int mov, int x, int y, Board board, Button[][] buttons, GridPane mapGrid){
        int diff=0;
        int rng=0;
        if (isMelee&&!isRanged) {rng=1;}
        if (!isMelee&&isRanged) {rng=2;}
        if (isMelee&&isRanged) {rng=1;}
        for (int i=(2+mov); i>=(-2-mov); i--){
            for (int j=(2+mov); j>=(-2-mov); j--){
                diff=Math.abs(x-(x-i))+Math.abs(y-(y-j));
                System.out.println(mov +" " +diff + "row:" + (x-i) +" col: " +(y-j));
                if (diff<=mov&&(((x-i)>=0)&&((x-i)<=7))&&(((y-j)>=0)&&((y-j)<=5))&&(board.getType(x-i,y-j)==3||(board.getType(x-i,y-j)==2))) {
                    for (Button[] bu: buttons){
                        for (Button b: bu){
                            if (mapGrid.getRowIndex(b)==x-i&&mapGrid.getColumnIndex(b)==y-j){
                                b.setStyle("-fx-background-color: #4286f4; ");
                                b.setOpacity(.4);
                            }

                        }
                    }
                }
                if (((((isMelee&&isRanged)&&(diff==mov+rng+1))||(diff==mov+rng))&&x-i>=0&&x-i<=7&&y-j>=0&&y-j<=5)||(x-i>=0&&x-i<=7&&y-j>=0&&y-j<=5&&board.getType(x-i, y-j)==1)){
                    for (Button[] bu: buttons){
                        for (Button b: bu){
                            if (mapGrid.getRowIndex(b)==x-i&&mapGrid.getColumnIndex(b)==y-j){
                                b.setStyle("-fx-background-color: #f23737; ");
                                b.setOpacity(.4);
                            }
                        }
                    }
                }
            }
        }
    }

    public void showEnemyRange(boolean isMelee, boolean isRanged, int mov, int x, int y, Board board, Button[][] buttons, GridPane mapGrid){
        int diff=0;
        int rng=0;
        if (isMelee&&!isRanged) {rng=1;}
        if (!isMelee&&isRanged) {rng=2;}
        if (isMelee&&isRanged) {rng=1;}
        for (int i=(2+mov); i>=(-2-mov); i--){
            for (int j=(2+mov); j>=(-2-mov); j--){
                diff=Math.abs(x-(x-i))+Math.abs(y-(y-j));
                System.out.println(mov +" " +diff + "row:" + (x-i) +" col: " +(y-j));

                if (diff<=mov&&(((x-i)>=0)&&((x-i)<=7))&&(((y-j)>=0)&&((y-j)<=5))&&board.getType(x-i,y-j)==3) {
                    for (Button[] bu: buttons){
                        for (Button b: bu){
                            if ((i<8&&i>=0)&&(j>=0&&j<6)&&(board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==1||board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==0)) 
                            {continue;}
                            if (mapGrid.getRowIndex(b)==x-i&&mapGrid.getColumnIndex(b)==y-j){
                                b.setStyle("-fx-background-color: #822828; ");
                                b.setOpacity(0.4);
                            }
                        }
                    }
                }
                if (((((isMelee&&isRanged)&&(diff==mov+rng+1))||(diff==mov+rng))&&x-i>=0&&x-i<=7&&y-j>=0&&y-j<=5)||(x-i>=0&&x-i<=7&&y-j>=0&&y-j<=5&&board.getType(x-i, y-j)==1)){
                    for (Button[] bu: buttons){
                        for (Button b: bu){
                            if ((i<8&&i>=0)&&(j>=0&&j<6)&&(board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==1||board.getType(mapGrid.getRowIndex(b), mapGrid.getColumnIndex(b))==0)) 
                            {continue;}
                            if (mapGrid.getRowIndex(b)==x-i&&mapGrid.getColumnIndex(b)==y-j){
                                b.setStyle("-fx-background-color: #822828; ");
                                b.setOpacity(0.4);
                            }
                        }
                    }
                }
            }
        }

    }

    public void setSidePanel(Unit unit, ImageView view, Label name, Label wep, Label hp, Label str, Label mag, Label skl, Label spd, Label lck, Label def, Label res){
        view.setImage(unit.getMug());
        name.setText(unit.getName());
        wep.setText(unit.getWeapon().getName());
        hp.setText("" +unit.getStats().get("HP") +" // " +unit.getOGHP());
        str.setText(" " +unit.getStats().get("STR"));
        mag.setText(" " +unit.getStats().get("MAG"));
        skl.setText(" " +unit.getStats().get("SKL"));
        spd.setText(" " +unit.getStats().get("SPD"));
        lck.setText(" " +unit.getStats().get("LCK"));
        def.setText(" " +unit.getStats().get("DEF"));
        res.setText(" " +unit.getStats().get("RES"));
    }

    public void setSidePanel(boolean left, ImageView view, Label name, Label wep, Label hp, Label str, Label mag, Label skl, Label spd, Label lck, Label def, Label res){
        if (left) {view.setImage(new Image("ruby_emblem.png", 160, 160, true, false));}
        if (!left) {view.setImage(new Image("weiss_emblem.png", 160, 160, true, false));}
        name.setText("");
        wep.setText("");
        hp.setText("");
        hp.setText("");
        str.setText("");
        mag.setText("" );
        skl.setText("" );
        spd.setText("" );
        lck.setText("" );
        def.setText("");
        res.setText("");
    }

    public void attackGUI(Unit unit, ArrayList<Unit> eops){
        //make a new stage and hide it when they press the button...........
        HBox h = new HBox();
        Button[] butts = new Button[eops.size()];
        int ucc = 1; // critical coefficient
        int ecc = 1; // enemy crit coefficient
        int ucritroll = -1; //unit crit
        int ecritroll = -1; //enemy crit
        int uhitroll = 0;  // unit hit
        int ehitroll = 0; // enemy hit
        HBox h1 = new HBox();
        VBox vmess = new VBox();
        if (eops.size()==0) {return;}
        for (int i=0; i<eops.size(); i++){
            Button battleButton = new Button();
            Unit enemy = eops.get(i);
            VBox v1 = new VBox();
            VBox v2 = new VBox();
            HBox h2 = new HBox();
            boolean melee=false;
            int ubc = unit.getStats().get("CR") - enemy.getStats().get("CE"); // battle critical rate
            int ebc = enemy.getStats().get("CR") - unit.getStats().get("CE"); // enemy crit rate
            int damage=0;
            int uba = unit.getStats().get("ACC") - enemy.getStats().get("AVO"); // battle accuracy
            int eba = enemy.getStats().get("ACC") - unit.getStats().get("AVO"); // enemy accuracy
            int uax = 0; //# of unit hits
            int eax = 0; //# of enem hits
            boolean enemyCounter=false;
            boolean unitDoubleAttack=false;
            boolean enemyDoubleAttack=false;
            if ((unit.getXPos()==enemy.getXPos() && ((unit.getYPos() -1 == enemy.getYPos())||(unit.getYPos()+1 == enemy.getYPos())))
            || (unit.getYPos()==enemy.getYPos() && ((unit.getXPos() -1 == enemy.getXPos())||(unit.getXPos()+1 == enemy.getXPos())))) {
                melee=true;
            }
            else {melee=false;}

            if ((unit.getWeapon().isMelee()&&enemy.getWeapon().isMelee()) || (unit.getWeapon().isRanged()&&enemy.getWeapon().isRanged())){
                enemyCounter=true; 
            }

            if (unit.getStats().get("AS") - enemy.getStats().get("AS") >= 4) {
                unitDoubleAttack = true; 
            } //can attacker double
            else if (enemyCounter && enemy.getStats().get("AS") - unit.getStats().get("AS") >= 4) {
                enemyDoubleAttack = true; 
            }
            ImageView unitv = new ImageView();
            unitv.setImage(unit.getMug());
            Label una = new Label(unit.getName());
            v1.getChildren().add(unitv);
            v1.getChildren().add(una);
            if (unitDoubleAttack) {uax = 2;}
            else {uax=1;}
            Label uhp = new Label(unit.getStats().get("HP") +" / " +(unit.getOGHP()));
            if (melee){
                damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
            }
            else {
                if (unit.getWeapon().getName().indexOf("Bow")!=-1) {
                    damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
                    //if unit has physical ranged attack, only works for bows
                }
                else {
                    damage = (unit.stats.get("MP") - enemy.getStats().get("RES"));
                    //all other ranged unit is magic, even Ruby because that's why she has low magic stat
                }
            }
            Label udg = new Label("Damage: " +(damage(unit, enemy)) +" (x " +uax +")");
            Label uht = new Label("Hit%: " +uba);
            Label ucr = new Label("Critical: " +ubc);
            Button ub = new Button("Attack");
            v1.getChildren().addAll(uhp, udg, uht, ucr);

            if ((enemy.getXPos()==unit.getXPos() && ((enemy.getYPos() -1 == unit.getYPos())||(enemy.getYPos()+1 == unit.getYPos())))
            || (enemy.getYPos()==unit.getYPos() && ((enemy.getXPos() -1 == unit.getXPos())||(enemy.getXPos()+1 == unit.getXPos())))) {
                melee=true;
            }
            else {melee=false;}
            ImageView enemv = new ImageView();
            enemv.setImage(enemy.getMug());
            Label ena = new Label(enemy.getName());
            v2.getChildren().add(enemv);
            v2.getChildren().add(ena);
            if (enemyDoubleAttack) {eax = 2;}
            else {eax=1;}
            Label ehp = new Label(enemy.getStats().get("HP") +" / " +(enemy.getOGHP()));
            if (melee){
                damage = (enemy.stats.get("PP") - unit.getStats().get("DEF"));
            }
            else {
                if (enemy.getWeapon().getName().indexOf("Bow")!=-1) {
                    damage = (enemy.stats.get("PP") - unit.getStats().get("DEF"));
                    //if unit has physical ranged attack, only works for bows
                }
                else {
                    damage = (enemy.stats.get("MP") - unit.getStats().get("RES"));
                    //all other ranged unit is magic, even Ruby because that's why she has low magic stat
                }
            }
            Label edg = new Label("Damage: " +(damage(enemy, unit)) +" (x " +eax +")");
            Label eht = new Label("Hit%: " +eba);
            Label ecr = new Label("Critical: " +ebc);
            v2.getChildren().addAll(ehp, edg, eht, ecr);
            Button eb = new Button("Attack");
            eb.setOnAction(e-> {
                    unit.battle(enemy, vmess);
                });
            v2.getChildren().add(eb);
            h2.getChildren().addAll(v1, v2);
            h1.getChildren().add(h2);
        }
        BorderPane pane = new BorderPane();
        pane.setTop(h1);
        pane.setBottom(vmess);
        Scene pbattle = new Scene(pane);

        Stage battleWindow = new Stage();
        battleWindow.setScene(pbattle);
        battleWindow.setTitle("Battle!");
        battleWindow.show();
    }

    public int damage(Unit unit, Unit enemy){
        int cc = 1; // critical coefficient
        int bc = unit.getStats().get("CR") - enemy.getStats().get("CE"); // battle critical rate
        int damage=0;
        int ba = unit.getStats().get("ACC") - enemy.getStats().get("AVO"); // battle accuracy
        if ((unit.getXPos()==enemy.getXPos() && ((unit.getYPos() -1 == enemy.getYPos())||(unit.getYPos()+1 == enemy.getYPos())))
        || (unit.getYPos()==enemy.getYPos() && ((unit.getXPos() -1 == enemy.getXPos())||(unit.getXPos()+1 == enemy.getXPos())))) {
            //if enemy is at melee distance
            damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
        }
        else {
            //if enemy is at range
            if (unit.getWeapon().getName().indexOf("Bow")!=-1) {
                damage = (unit.stats.get("PP") - enemy.getStats().get("DEF"));
                //if unit has physical ranged attack, only works for bows
            }
            else {
                damage = (unit.stats.get("MP") - enemy.getStats().get("RES"));
                //all other ranged unit is magic, even Ruby because that's why she has low magic stat
            }
        }
        if (damage<0) {return 0;}
        else {return damage;}
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
