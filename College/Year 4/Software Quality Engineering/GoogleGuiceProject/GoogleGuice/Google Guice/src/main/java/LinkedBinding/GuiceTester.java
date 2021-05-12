/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedBinding;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
/**
 *
 * @author Sean
 */
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
   
   public TextEditor(SpellChecker spellChecker) {
      this.spellChecker = spellChecker;
   }
   public void makeSpellCheck() {
      spellChecker.checkSpelling();
   }
}

//Binding Module
class TextEditorModule extends AbstractModule {
   @Override
   
   protected void configure() {
      bind(SpellChecker.class).to(SpellCheckerImpl.class);
      bind(SpellCheckerImpl.class).to(WinWordSpellCheckerImpl.class);
   } 
}

//spell checker interface
interface SpellChecker {
   public void checkSpelling();
}

//spell checker implementation
class SpellCheckerImpl implements SpellChecker {
   @Override
   
   public void checkSpelling() {
      System.out.println("Inside checkSpelling." );
   } 
}

//subclass of SpellCheckerImpl
class WinWordSpellCheckerImpl extends SpellCheckerImpl {
   @Override
   
   public void checkSpelling() {
      System.out.println("Inside WinWordSpellCheckerImpl.checkSpelling." );
   } 
}
