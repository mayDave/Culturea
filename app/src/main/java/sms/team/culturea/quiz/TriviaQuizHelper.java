package sms.team.culturea.quiz;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


class TriviaQuizHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DB_NAME = "TQuiz.db";

    //If you want to add more questions or wanna update table values
    //or any kind of modification in db just increment version no.
    private static final int DB_VERSION = 3;
    //Table name
    private static final String TABLE_NAME = "TQ";
    //Id of question
    private static final String UID = "_UID";
    //Question
    private static final String QUESTION = "QUESTION";
    //Option A
    private static final String OPTA = "OPTA";
    //Option B
    private static final String OPTB = "OPTB";
    //Option C
    private static final String OPTC = "OPTC";
    //Option D
    private static final String OPTD = "OPTD";
    //Answer
    private static final String ANSWER = "ANSWER";
    //So basically we are now creating table with first column-id , sec column-question , third column -option A, fourth column -option B , Fifth column -option C , sixth column -option D , seventh column - answer(i.e ans of  question)
    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ( " + UID + " INTEGER PRIMARY KEY AUTOINCREMENT , " + QUESTION + " VARCHAR(255), " + OPTA + " VARCHAR(255), " + OPTB + " VARCHAR(255), " + OPTC + " VARCHAR(255), " + OPTD + " VARCHAR(255), " + ANSWER + " VARCHAR(255));";
    //Drop table query
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    TriviaQuizHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //OnCreate is called only once
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //OnUpgrade is called when ever we upgrade or increment our database version no
        sqLiteDatabase.execSQL(DROP_TABLE);
        onCreate(sqLiteDatabase);
    }

    void allQuestion() {
        ArrayList<TriviaQuestion> arraylist = new ArrayList<>();

        arraylist.add(new TriviaQuestion("Cosa ha sviluppato l'astronomo Galileo Galilei?", "Telescopio", "Aereoplano", "Elettricità", "Treno", "Telescopio"));

        arraylist.add(new TriviaQuestion("Chi è il padre della geometria?", "Aristotele", "Euclide", "Pitagora", "Keplero", "Euclide"));

        arraylist.add(new TriviaQuestion("Quale di questi animali è in via di estinzione?", "Lama", "Dinosauro", "Alpaca", "Tigre di Giava", "Alpaca"));

        arraylist.add(new TriviaQuestion("Chi è stata la prima donna nello spazio?", "Valentina Tereshkova", "Sally Ride", "Naidia Comenci", "Tamara Press", "Valentina Tereshkova"));

        arraylist.add(new TriviaQuestion("Quale di queste NON è una delle 7 meraviglie del mondo?", "Colosseo", "Chichén Itzá", "Pantheon", "Grande muraglia cinese", "Pantheon"));

        arraylist.add(new TriviaQuestion("Chi è il migliore del team?", "Claudio", "Pit", "Antonio", "Davide", "Claudio"));

        arraylist.add(new TriviaQuestion("Che tipo di animale è il pinguino?", "Pesce", "Uccello", "Mammifero", "Rettile", "Uccello"));

        arraylist.add(new TriviaQuestion("Quale di questi animali non vive in gruppo?", "Ippopotami", "Lupi", "Pecore", "Aquile", "Aquile"));

        arraylist.add(new TriviaQuestion("Quale è la montagna più alta d'Italia?", "Monte Bianco", "Gran Sasso", "Cervino", "Monte Rosa", "Monte Bianco"));

        arraylist.add(new TriviaQuestion("Come si chiama un appassionato di cinema?", "Cinofilo", "Cinematografo", "Cinematico", "Cinefilo", "Cinefilo"));

        arraylist.add(new TriviaQuestion("Qual è la materia più bella di questa università?", "Sviluppo di Mobile Software", "Matematica Discreta", "Analisi", "Nessuna", "Sviluppo di Mobile Software"));

        arraylist.add(new TriviaQuestion("Chi ha inventato la famosa formula E=mc^2?", "Albert Einstein", "Galileo", "Pitagora", "Bill Gates", "Albert Einstein"));

        arraylist.add(new TriviaQuestion("Dove sorge il sole?", "Nord", "Est", "Sud", "Ovest", "Est"));

        arraylist.add(new TriviaQuestion("Chi è il fondatore della compagnia Microsoft?", "Bill Gates", "Bill Clinton", "Jhon rio", "Steve jobs", "Bill Gates"));

        arraylist.add(new TriviaQuestion("Chi è il fondatore della compagnia Apple?", "Steve Jobs", "Steve Washinton", "Bill Gates", "Jobs Wills", "Steve Jobs"));

        arraylist.add(new TriviaQuestion("Chi è il fondatore della compagnia Google?", "Steve Jobs", "Bill Gates", "Larry Page", "Sundar Pichai", "Larry Page"));

        arraylist.add(new TriviaQuestion("Qual è lo stato più piccolo del mondo?", "Città del Vaticano", "Isole Marshall", "San Marino", "Maldive", "Città del Vaticano"));

        arraylist.add(new TriviaQuestion("Come si chiama la forma della terra?", "Ellisse", "Sfera", "Geoide", "Cilindro", "Geoide"));

        arraylist.add(new TriviaQuestion("Qual è elemento più presente nell'aria?", "Anidride Carbonica", "Azoto", "Ossigeno", "Argon", "Azoto"));

        arraylist.add(new TriviaQuestion("Qual è il materiale più duro conosciuto?", "Diamante", "Ossidiana", "Titanio", "Grafene", "Diamante"));

        arraylist.add(new TriviaQuestion("A quale numero corrisponde 0001 0010 in sistema binario?", "7", "18", "2", "66", "18"));

        arraylist.add(new TriviaQuestion("Qual è il gruppo sanguigno più raro tra tutti?", "A", "B", "AB", "0", "AB"));

        arraylist.add(new TriviaQuestion("Quante ossa ci sono nel corpo umano?", "100", "106", "200", "206", "206"));

        arraylist.add(new TriviaQuestion("Quale di questi stati non è parte della Gran Bretagna?", "Inghilterra", "Irlanda", "Galles", "Scozia", "Irlanda"));

        arraylist.add(new TriviaQuestion("Qual è il materiale più duro conosciuto?", "Diamante", "Ossidiana", "Titanio", "Grafene", "Diamante"));

        arraylist.add(new TriviaQuestion("Qual è l'Oceano più grande del mondo?", "Oceano Atlantico", "Oceano Pacifico", "Oceano Indiano", "Oceano Artico", "Oceano Pacifico"));

        arraylist.add(new TriviaQuestion("Qual è il più grande animale vivente?", "Squalo balena", "Balenottera azzurra", "Capodoglio", "Balenottera comune", "Balenottera azzurra"));

        arraylist.add(new TriviaQuestion("Di cosa si nutre principalmente il panda?", "Bacche", "Soia", "Foglie di agave", "Bambù", "Bambù"));

        arraylist.add(new TriviaQuestion("Cosa permetterebbe di trasmutare i metalli vili in oro secondo gli alchimisti?", "Pietra Lunare", "Pietra filosofale", "Opale", "Ametista", "Pietra filosofale"));

        arraylist.add(new TriviaQuestion("Di cosa si nutre principalmente il panda?", "Bacche", "Soia", "Foglie di agave", "Bambù", "Bambù"));

        arraylist.add(new TriviaQuestion("Come si chiama la punta dei lacci?", "Puntale", "Rebbi", "Ibisco", "Rondine", "Puntale"));

        this.addAllQuestions(arraylist);

    }


    private void addAllQuestions(ArrayList<TriviaQuestion> allQuestions) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            for (TriviaQuestion question : allQuestions) {
                values.put(QUESTION, question.getQuestion());
                values.put(OPTA, question.getOptA());
                values.put(OPTB, question.getOptB());
                values.put(OPTC, question.getOptC());
                values.put(OPTD, question.getOptD());
                values.put(ANSWER, question.getAnswer());
                db.insert(TABLE_NAME, null, values);
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
            db.close();
        }
    }


    List<TriviaQuestion> getAllOfTheQuestions() {

        List<TriviaQuestion> questionsList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        String coloumn[] = {UID, QUESTION, OPTA, OPTB, OPTC, OPTD, ANSWER};
        Cursor cursor = db.query(TABLE_NAME, coloumn, null, null, null, null, null);


        while (cursor.moveToNext()) {
            TriviaQuestion question = new TriviaQuestion();
            question.setId(cursor.getInt(0));
            question.setQuestion(cursor.getString(1));
            question.setOptA(cursor.getString(2));
            question.setOptB(cursor.getString(3));
            question.setOptC(cursor.getString(4));
            question.setOptD(cursor.getString(5));
            question.setAnswer(cursor.getString(6));
            questionsList.add(question);
        }

        db.setTransactionSuccessful();
        db.endTransaction();
        cursor.close();
        db.close();
        return questionsList;
    }
}
