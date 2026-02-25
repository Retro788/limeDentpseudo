package view.viewPanel;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import design.txtInput.TextField;


/**
 *
 * La clase InputControls proporciona métodos estáticos para validar los
 * campos de entrada como el DNI, CURP, número de teléfono y correo
 * electrónico.
 */
public class InputControls {
	
	/**
	 *
     * Valida el DNI proporcionado (11 caracteres numéricos) y muestra un mensaje
     * de ayuda en el campo dependiendo del resultado de la validación.
	 *
	 * @param txtOIB The text field to validate.
	 *
     * @return {@code true} si el DNI es válido, {@code false} en caso contrario.
	 */
	public static boolean checkOIB( TextField txtOIB ) {
		
		String oib = txtOIB.getText();
		
		boolean isOIBValid = true;
		
//		Comprobamos que tenga 11 dígitos numéricos
		if ( oib.length() != 11 ) {
			
			isOIBValid = false;
			
		} else {
			
			char[] chars = oib.toCharArray();
			
			for ( char c : chars ) {
				
				if ( c < '0' || c > '9' ) {
					
					isOIBValid = false;
					
				}
				
			}
			
		}
		
//		Si la entrada está vacía no se valida
		if ( oib.equals( "" ) ) {
			
			isOIBValid = true;
			
		}
		
//		Mostramos la ayuda según el resultado
		if ( !isOIBValid ) {
			
                        txtOIB.setHelperText( "Formato de DNI inválido." );
			
		} else {
			
			txtOIB.setHelperText( "" );
			
		}
		
		return isOIBValid;
		
	}
	
	
	/**
	 *
	 * Validates the provided JMBG (13 numeric characters) and sets helper text on
         * Valida la CURP proporcionada (18 caracteres alfanuméricos) y muestra un
         * mensaje de ayuda cuando el formato es inválido.
         *
         * @param txtJMBG Campo de texto a validar.
         *
         * @return {@code true} si la CURP es válida, {@code false} en caso contrario.
         */
        public static boolean checkCURP( TextField txtJMBG ) {

                String jmbg = txtJMBG.getText();

                boolean isJMBGValid = true;

                // Validación: 18 caracteres alfanuméricos
                if ( jmbg.length() != 18 ) {

                        isJMBGValid = false;

                } else {

                        char[] chars = jmbg.toCharArray();

                        for ( char c : chars ) {

                                if ( !Character.isLetterOrDigit( c ) ) {

                                        isJMBGValid = false;

                                }

                        }

                }

                // Si la entrada está vacía no se valida
                if ( jmbg.equals( "" ) ) {

                        isJMBGValid = true;

                }

                // Mostramos la ayuda según el resultado
                if ( !isJMBGValid ) {

                        txtJMBG.setHelperText( "Formato de CURP inválido." );

                } else {

                        txtJMBG.setHelperText( "" );

                }

                return isJMBGValid;

        }
	
	
	/**
         * Valida el número de teléfono mediante una expresión regular y muestra
         * un mensaje de ayuda si el formato es inválido.
         *
         * @param txtBrojMobitela Campo de texto a validar.
         *
         * @return {@code true} si el número es válido, en caso contrario {@code false}.
         */
        public static boolean checkPhone( TextField txtBrojMobitela ) {
		String phone = txtBrojMobitela.getText();
                boolean isPhoneValid = true;
		
		String regex = "^\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}$";
		Pattern pattern = Pattern.compile( regex );
		Matcher matcher = pattern.matcher( phone );
		
//		Checking if input String matches regex
		if ( !matcher.matches() ) {
			
			isPhoneValid = false;
			
		}
		
//		Si la entrada está vacía no se valida
		if ( phone.equals( "" ) ) {
			
			isPhoneValid = true;
			
		}
		
//		Mostramos la ayuda según el resultado
		if ( !isPhoneValid ) {
			
			txtBrojMobitela.setHelperText( "Formato de número de móvil inválido." );
			
		} else {
			
			txtBrojMobitela.setHelperText( "" );
			
		}
		
		return isPhoneValid;
		
	}
	
	
	/**
	 *
	 * Validates the provided email address using a regular expression and sets
	 * helper text on the given text field based on the validation result.
	 *
	 * @param txtMail The text field to validate.
         * Valida la dirección de correo electrónico mediante una expresión
         * regular y muestra un mensaje de ayuda si el formato es inválido.
         *
         * @param txtMail Campo de texto a validar.
         *
         * @return {@code true} si el correo es válido, de lo contrario {@code false}.
         */
        public static boolean checkMail( TextField txtMail ) {

                boolean isMailValid = true;
                String mail = txtMail.getText();

                String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}";
                Pattern pattern = Pattern.compile( regex );
                Matcher matcher = pattern.matcher( mail );

                // Comprobamos que coincida con la expresi\u00f3n regular
                if ( !matcher.matches() ) {
                        isMailValid = false;
                }

                // Si la entrada est\u00e1 vac\u00eda no se valida
                if ( mail.equals( "" ) ) {
                        isMailValid = true;
                }

                // Mostramos la ayuda seg\u00fan el resultado
                if ( !isMailValid ) {
                        txtMail.setHelperText( "Formato de correo inv\u00e1lido." );
                } else {
                        txtMail.setHelperText( "" );
                }

                return isMailValid;
        }
}
