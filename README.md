# Sunshine Weather App

## Introduction

I learned to build this Android app in the Udacity course [Developing Android Apps: Android Fundamentals](https://www.udacity.com/course/ud853). This course is amazing!

<img src="https://github.com/ymittal/SunshineWeatherApp/blob/sunshine_master/Screenshots/Screenshot_2015-12-26-03-44-39.png" width="270" height="480">

## Functionality

The weather application fetches data from Open Weather Map API. You can modify `SYNC_INTERVAL` in `SunshineSyncService.java` to change how frequently the application checks for weather updates. Following is a sample detailed screen (I won't lie but it hasn't snowed even once so far):

<img src="https://github.com/ymittal/SunshineWeatherApp/blob/sunshine_master/Screenshots/Screenshot_2015-12-26-03-44-48.png" width="270" height="480">

You can choose to change the location or measurement units. There is also a notification toggle for people who would like to receive a notification every day. Who opens a weather app anyway, right?

<img src="https://github.com/ymittal/SunshineWeatherApp/blob/sunshine_master/Screenshots/Screenshot_2015-12-26-03-45-56.png" width="270" height="480">


**Add Open Weather Map API Key**

All Open Weather Map API calls must have a unique key. You can obtain your key [here](http://openweathermap.org/appid#use). To reflect changes, you need to update `/app/build.gradle`

For someone with API key as `a1234567891011121314151617181920`, `/app/build.gradle` should look as follows: 

	apply plugin: 'com.android.application'

	android {
	    compileSdkVersion 21
	    buildToolsVersion "21.1.2"

	    defaultConfig {
	        applicationId "com.example.android.sunshine.app"
	        minSdkVersion 10
	        targetSdkVersion 21
	        versionCode 1
	        versionName "1.0"
	    }
	    buildTypes {
	        release {
	            minifyEnabled false
	            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
	        }
	    }
	    buildTypes.each {
	        it.buildConfigField 'String', 'OPEN_WEATHER_MAP_API_KEY', "\"a1234567891011121314151617181920\""
	    }
	}

	dependencies {
	    compile fileTree(dir: 'libs', include: ['*.jar'])
	    compile 'com.android.support:appcompat-v7:21.0.2'
	}

# Additional Information

* For the original repository, please click [here](https://github.com/udacity/Sunshine-Version-2).
* Check the project [license](https://github.com/ymittal/SunshineWeatherApp/blob/sunshine_master/LICENSE).
