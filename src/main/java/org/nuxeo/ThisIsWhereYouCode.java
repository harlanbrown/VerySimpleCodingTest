package org.nuxeo;


/**
 * This is where you have to code.
 * 
 * See javadoc and associated unit tests to understand what is expected
 * 
 * @author tiry
 *
 */
public class ThisIsWhereYouCode {

    /**
     * input will be a string, but it may not have a file extension. return the file
     * extension (with no period) if it has one, otherwise null
     * 
     * @param filename
     * @return null if input is null or filename has no extension and the
     *         extension without the period otherwise
     */
    public String getFileNameExtension(String filename) {
    	if (filename!=null){

    		if (filename.contains(".")){
    			return filename.substring(filename.indexOf('.')+1);
    		} else {
    			return null;
    		}
    		    		
    	} else {
    		return null;
    	}
    
    }

    /**
     * return the longest string contained inside the input array
     * 
     * @param array input Array of values
     * @return null if input is null and the longest string otherwise
     */
    public String getLongestString(Object[] array) {
    	if (array != null){
        	
    		int n = 0;
    		String longest = "";
    		for (Object o : array){
    			if (o != null){
    				String s = new String();
    				if ( o.getClass().isArray() ){

    					s = getLongestString((Object[]) o);

    				} else {

    					if (o.getClass().equals(String.class))
    					{
    						s = (String) o;
    					}
    					else if(o.getClass().equals(Integer.class)) {
    						s="";
    					}

    				}
    				int l = s.length();
    				if (l > n){
    					n = l;
    					longest = s;
    				}    		
    			}
       		}
        	return longest;
        }
       	return null;
    }

    /**
     * Returns true is both arrays contains the same values
     * 
     * @param array1 first Array to test
     * @param array2 second Array to test
     * @return true if both arrays contains the same values
     */
    public boolean areArraysEquals(String[] array1, String[] array2) {
    	if (array1 == null && array2 == null){
    		return true;
    	}
       	if (array1 == null || array2 == null){
    		return false;
    	}
		if (array1.length == array2.length){
			if (array1.length == 0){
				return true;
			} 
			else {
				for (int i = 0; i < array1.length; i++){
					if (array1[i] != array2[i]){
						return false;
					}
				}
				return true;
			}
			
        } 
        return false;
    }

    /**
     * Compress the input string with a very dummy algorithm : repeated letters
     * are replaced by {n}{letter} where n is the number of repetition and
     * {letter} is the letter. n must be superior to 1 (otherwise, simply output
     * the letter)
     * 
     * @param input the input string that can only contains letters
     * @return the compressed String or null if the input is null
     */
    public String getCompressedString(String input) {
        if (input == null){        	
        	return null;
        } else {
        	
        	String output = "";
    		int j = 0;
        	for (int i=0; i < input.length(); i++){
        		char c = input.charAt(i);
        		
        		if (i < input.length()-1 ){ 
        			
        			if (c == input.charAt(i+1) ){
        				j = j + 1;
        			} else {
        				j = j + 1;
        				if (j > 1){
            				output = output + j + c;
           				} else {
           					output = output + c;
           				}
        				j = 0;
        			}
        			
        		} else {
        			j = j + 1;
    				if (j > 1){
        				output = output + j + c;
       				} else {
       					output = output + c;
       				}
    				j = 0;
        		}
        		
        	}
    	    return output;
        }
    }

    /**
     * Sort the input array of string based on lexicographic order of the
     * corresponding compressed string
     * 
     * @param array the Array to sort
     * @return the sorted array
     */
    public String[] getSortedArray(String[] array) {
    	
    	for (int i = 0 ; i < array.length ; i++)
    	{
    		String x = array[i];
    		int j = i;
    		while ( (j > 0) && (getCompressedString(array[j-1]).compareTo(getCompressedString(x))>0)){
    			array[j] = array[j-1];
    			j = j - 1;
    		}
    		array[j] = x;
    		
    	}
        return array;
    }

}
