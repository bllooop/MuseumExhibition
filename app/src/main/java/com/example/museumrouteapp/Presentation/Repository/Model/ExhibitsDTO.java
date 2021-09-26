package com.example.museumrouteapp.Presentation.Repository.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.museumrouteapp.Domain.Model.Exhibit;


@Entity
        //(tableName = "exhibit_table")
public class ExhibitsDTO extends Exhibit {
        @PrimaryKey(autoGenerate = true)
        public int uid;

        @ColumnInfo(name="ExhibitName")
        public String exhibitName;

        @ColumnInfo(name="ExhibitRouteNum")
        public int ExhibitRouteNum;

        @ColumnInfo(name="ExhibitUrl")
        public String ExhibitPicUrl;

    }

