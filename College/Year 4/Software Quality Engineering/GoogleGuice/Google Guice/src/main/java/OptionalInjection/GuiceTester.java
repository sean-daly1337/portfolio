
package OptionalInjection;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class GuiceTester {
   public static void main(String[] args) {
      Injector injector = Guice.createInjector(new TextEditorModule());
      TextEditor editor = injector.getInstance(TextEditor.class);
      editor.makeSpellCheck();
   } 
}
class TextEditor {
   private SpellChecker spellChecker;

   @Inject
   public TextEditor( SpellChecker spellChecker) {
      this.spellChecker = spellChecker;
   }
   public void makeSpellCheck() {
      spellChecker.checkSpelling();
   } 
}


//Binding Module
class TextEditorModule extends AbstractModule {
   @Override
   protected void configure() {} 
}
@ImplementedBy(SpellCheckerImpl.class)
interface SpellChecker {
   public void checkSpelling();
}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {
   private String dbUrl = "jdbc:mysql://localhost:5326/emp";
   public SpellCheckerImpl(){}
   
   @Inject(optional=true)
   public void setDbUrl(@Named("JDBC") String dbUrl) {
      this.dbUrl = dbUrl;
   }
   @Override
   public void checkSpelling() { 
      System.out.println("Inside checkSpelling." );
      System.out.println(dbUrl); 
   }
}