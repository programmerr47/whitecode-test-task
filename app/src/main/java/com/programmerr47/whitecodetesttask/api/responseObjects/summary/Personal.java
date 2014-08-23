package com.programmerr47.whitecodetesttask.api.responseObjects.summary;

import com.programmerr47.whitecodetesttask.api.util.JSONUtil;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.MainInLifeType;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.MainQualitiesType;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.PoliticalType;
import com.programmerr47.whitecodetesttask.api.accessoryEnums.RelationToAnythingType;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Object for representing personal information about user.
 *
 * @author Michael Spitsin
 * @since 204-08-23
 */
public class Personal {
    private static final String POLITICAL_TAG = "political";
    private static final String LANGS_TAG = "langs";
    private static final String RELIGION_TAG = "religion";
    private static final String INSPIRED_BY_TAG = "inspired_by";
    private static final String PEOPLE_MAIN_TAG = "people_main";
    private static final String LIFE_MAIN_TAG = "life_main";
    private static final String SMOKING_TAG = "smoking";
    private static final String ALCOHOL_TAG = "alcohol";

    private PoliticalType politicalType;
    private List<String> langs;
    private String religion;
    private String inspiredBy;
    private MainQualitiesType mainQualities;
    private MainInLifeType mainInLife;
    private RelationToAnythingType relationToSmoking;
    private RelationToAnythingType relationToAlcohol;

    public Personal(Builder builder) {
        this.politicalType = builder.politicalType;
        this.langs = builder.langs;
        this.religion = builder.religion;
        this.inspiredBy = builder.inspiredBy;
        this.mainQualities = builder.mainQualities;
        this.mainInLife = builder.mainInLife;
        this.relationToSmoking = builder.relationToSmoking;
        this.relationToAlcohol = builder.relationToAlcohol;
    }

    @SuppressWarnings("unused")
    public PoliticalType getPoliticalType() {
        return politicalType;
    }

    @SuppressWarnings("unused")
    public List<String> getLangs() {
        return langs;
    }

    @SuppressWarnings("unused")
    public String getReligion() {
        return religion;
    }

    @SuppressWarnings("unused")
    public String getInspiredBy() {
        return inspiredBy;
    }

    @SuppressWarnings("unused")
    public MainQualitiesType getMainQualities() {
        return mainQualities;
    }

    @SuppressWarnings("unused")
    public MainInLifeType getMainInLife() {
        return mainInLife;
    }

    @SuppressWarnings("unused")
    public RelationToAnythingType getRelationToSmoking() {
        return relationToSmoking;
    }

    @SuppressWarnings("unused")
    public RelationToAnythingType getRelationToAlcohol() {
        return relationToAlcohol;
    }

    private static class Builder {
        private PoliticalType politicalType;
        private List<String> langs;
        private String religion;
        private String inspiredBy;
        private MainQualitiesType mainQualities;
        private MainInLifeType mainInLife;
        private RelationToAnythingType relationToSmoking;
        private RelationToAnythingType relationToAlcohol;

        public Builder setPoliticalType(PoliticalType politicalType) {
            this.politicalType = politicalType;
            return this;
        }

        public Builder setLangs(List<String> langs) {
            this.langs = langs;
            return this;
        }

        public Builder setReligion(String religion) {
            this.religion = religion;
            return this;
        }

        public Builder setInspiredBy(String inspiredBy) {
            this.inspiredBy = inspiredBy;
            return this;
        }

        public Builder setMainQualities(MainQualitiesType mainQualities) {
            this.mainQualities = mainQualities;
            return this;
        }

        public Builder setMainInLife(MainInLifeType mainInLife) {
            this.mainInLife = mainInLife;
            return this;
        }

        public Builder setRelationToSmoking(RelationToAnythingType relationToSmoking) {
            this.relationToSmoking = relationToSmoking;
            return this;
        }

        public Builder setRelationToAlcohol(RelationToAnythingType relationToAlcohol) {
            this.relationToAlcohol = relationToAlcohol;
            return this;
        }

        public Personal build() {
            return new Personal(this);
        }
    }

    /**
     * Creates {@link Personal} object from its JSON Counterpart.
     *
     * @param jsonObject - given JSON object
     * @return new instance of Personal or null, if json is null
     */
    @SuppressWarnings("unused")
    public static Personal getFromJSONObject(JSONObject jsonObject) {
        if (jsonObject == null) {
            return null;
        } else {
            return new Builder()
                    .setInspiredBy(jsonObject.optString(INSPIRED_BY_TAG, null))
                    .setLangs(JSONUtil.getStringList(jsonObject.optJSONArray(LANGS_TAG)))
                    .setMainInLife(MainInLifeType.getFromInt(jsonObject.optInt(LIFE_MAIN_TAG, 0)))
                    .setMainQualities(MainQualitiesType.getFromInt(jsonObject.optInt(PEOPLE_MAIN_TAG, 0)))
                    .setPoliticalType(PoliticalType.getFromInt(jsonObject.optInt(POLITICAL_TAG, 0)))
                    .setRelationToAlcohol(RelationToAnythingType.getFromInt(jsonObject.optInt(ALCOHOL_TAG, 0)))
                    .setRelationToSmoking(RelationToAnythingType.getFromInt(jsonObject.optInt(SMOKING_TAG, 0)))
                    .setReligion(jsonObject.optString(RELIGION_TAG, null))
                    .build();
        }
    }

    /**
     * Creates list of {@link Personal} objects from its JSON Counterpart.
     *
     * @param jsonArray - given JSON array
     * @return new instance of Personal or null, if json is null
     */
    @SuppressWarnings("unused")
    public static List<Personal> getFromJSONArray(JSONArray jsonArray) {
        if (jsonArray == null) {
            return null;
        } else {
            List<Personal> resultList = new ArrayList<Personal>();
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.optJSONObject(i);
                if (jsonObject != null) {
                    resultList.add(getFromJSONObject(jsonObject));
                }
            }
            return resultList;
        }
    }
}
