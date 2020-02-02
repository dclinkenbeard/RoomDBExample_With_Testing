package com.daclink.drew.gymlogv2.DB.TypeConverter;

import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

public class BooleanTypeConverter {
    @TypeConverter
    public int convertBooleanToInt(boolean bool){
        return bool ? 1 : 0;
    }

    @TypeConverter
    public boolean convertInttoBoolean(int trueFalse){
        return trueFalse == 1;
    }

}
