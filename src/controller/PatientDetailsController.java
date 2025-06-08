package controller;


import dao.PatientDAO;
import model.Patient;
import view.viewPanel.PatientDetailsPanel;



public class PatientDetailsController {
	
	private PatientDetailsPanel detaljiPanel;
	private PatientDAO patientDAO;
	
    /**
     * Crea una nueva instancia del controlador de detalles e inicializa el
     * objeto DAO.
     */
    public PatientDetailsController() {
		
		this.patientDAO = new PatientDAO();
		
	}
	
	
    /**
     * Obtiene de la base de datos la información actual del paciente
     * establecido en el panel y actualiza los campos visibles.
     */
    public void setPatientData() {

        if ( detaljiPanel == null ) {
            return;
        }

        Patient current = detaljiPanel.getPatient();
        if ( current != null && current.getId() != null ) {
            Patient fresh = patientDAO.getPatientByID( current.getId() );
            if ( fresh != null ) {
                detaljiPanel.setPatient( fresh );
            }
        }
    }
	
	
    /**
     * Elimina el paciente especificado de la base de datos.
     *
     * @param patient el paciente a eliminar
     */
    public void deletePatient( Patient patient ) {
		
		patientDAO.deletePatient( patient );
		
	}
	
	
    /**
     * Actualiza la información del paciente especificado en la base de datos.
     *
     * @param patient el paciente a actualizar
     */
    public void updatePatient( Patient patient ) {
		
		System.out.println( "Update Patient" );
                patient.setOib( Long.valueOf( detaljiPanel.getTxtOIB().getText() ) );
		patient.setName( detaljiPanel.getTxtimePrezime().getText() );
                patient.setCurp( detaljiPanel.getTxtCURP().getText() );
		patient.setAddress( detaljiPanel.getTxtAdresa().getText() );
		patient.setCity( detaljiPanel.getTxtGrad().getText() );
		patient.setPhone( detaljiPanel.getTxtBrojMobitela().getText() );
		patient.setMail( detaljiPanel.getTxtMail().getText() );
		patient.setMedicalHistory( detaljiPanel.getTxtPovijestBolesti().getText() );
		patient.setAlergies( detaljiPanel.getTxtAlergije().getText() );
		patientDAO.updatePatient( patient );
		
	}
	
	
    /**
     * Actualiza la foto del paciente especificado en la base de datos.
     *
     * @param patient el paciente cuya foto se actualizará
     */
    public void updatePatientPhoto( Patient patient ) {
		
		patientDAO.updatePatientPhoto( patient );
		
	}
	
	
    /**
     * Devuelve el panel de detalles asociado a este controlador.
     *
     * @return el panel de detalles
     */
    public PatientDetailsPanel getDetaljiPanel() {
		
		return detaljiPanel;
		
	}
	
	
    /**
     * Asigna el panel de detalles asociado a este controlador.
     *
     * @param detaljiPanel el panel de detalles a asignar
     */
    public void setDetaljiPanel( PatientDetailsPanel detaljiPanel ) {
		
		this.detaljiPanel = detaljiPanel;
		
	}
	
}
