package position;

import util.ValidationUtilities;

/**
 *
 * @author 186946
 */
public abstract class AbstractPosition implements Position{
    private final String notation;

    public AbstractPosition(String notation) {
        if(ValidationUtilities.isNullOrEmpty(notation)){
            throw new IllegalArgumentException("Notation can not be null or empty");
        }
        this.notation = notation;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
         AbstractPosition other = (AbstractPosition) obj;
        
        return this.notation.equals(other.getNotation());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.notation != null ? this.notation.hashCode() : 0);
        return hash;
    }

    protected String getNotation() {
        return notation;
    }

    @Override
    public String toString() {
        return notation;
    }
    
     public static Position parsePosition(String position) {
        if (position == null || position.length() == 0 || position.length() > 1) {
            throw new IllegalArgumentException(" position can not be empty or null and length should be 1");
        }
        
        char positionChar = position.charAt(0);
        switch (positionChar) {
            case 'N':
                return new NorthPosition();
            case 'S':
                return new SouthPosition();
            case 'E':
                return new EastPosition();
            case 'W':
                return new WestPosition();

            default:
                throw new IllegalArgumentException("["+positionChar+"] is not a valide position must be one of {N S E W}");

        }
    }
}
