package com.lohika

class GlobalConfig {
    public static defaults = [
            "k8s" : [
                    "dev": [
                            "clusterUrl": "k8s.local",
                            "credentialsId": "k8s-dev-access"
                    ],
                    "stg": [],
                    "prd": []
            ]

    ]
}