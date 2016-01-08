package domain;

import java.math.BigDecimal;

/**
 * @author umut - pc
 *
 */
public class ProjectManager extends AUser {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    private static final String PM_SALARY = "10000.0";

    public ProjectManager() {
        this.setSalary(new BigDecimal(PM_SALARY));
    }

	@Override
	public int getFieldCount() {
		// TODO Auto-generated method stub
		return 0;
	}
    
    
}
