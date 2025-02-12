/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InbuiltBindings;
import java.util.logging.Logger;

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
   private Logger logger;

   @Inject
   public TextEditor( Logger logger) {
      this.logger = logger;
   }
   public void makeSpellCheck() {
      logger.info("In TextEditor.makeSpellCheck() method");
   } 
}

//Binding Module
class TextEditorModule extends AbstractModule {

   @Override
   protected void configure() {
   } 
}
