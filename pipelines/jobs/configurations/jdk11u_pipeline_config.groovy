class Config11 {
  final Map<String, Map<String, ?>> buildConfigurations = [
        x64MacIBM    : [
                os                  : 'mac',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.osx.10_14',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto  --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"
        ],

        x64LinuxIBM  : [
                os                  : 'linux',
                arch                : 'x64',
                additionalNodeLabels : 'ci.project.openj9 && hw.arch.x86 && sw.os.linux',
                dockerImage         : 'adoptopenjdk/centos6_build_image@sha256:19cdb5284da031aef7c73cb52ee7018502d65d0ca21cebc45d9652eec3926458',
                dockerFile: [
                        openj9  : 'pipelines/build/dockerFiles/cuda.dockerfile'
                ],
                dockerNode          : 'sw.tool.docker && sw.config.uid1000',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--enable-jitserver --enable-dtrace=auto --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"
        ],

        x64WindowsIBM: [
                os                  : 'windows',
                arch                : 'x64',
                additionalNodeLabels: [
                        openj9:     'ci.project.openj9 && hw.arch.x86 && sw.os.windows'
                ],
                buildArgs : [
                        openj9 : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM"
        ],

        ppc64AixIBM    : [
                os                  : 'aix',
                arch                : 'ppc64',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64 && sw.os.aix.7_1'
                ],
                test                : 'default',
                configureArgs       : [
                        "openj9"      : '--with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"
        ],

        s390xLinuxIBM    : [
                os                  : 'linux',
                arch                : 's390x',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.s390x && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : '--enable-dtrace=auto --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"',
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"
        ],

        ppc64leLinuxIBM    : [
                os                  : 'linux',
                arch                : 'ppc64le',
                additionalNodeLabels : 'centos7',
                test                : 'default',
                additionalNodeLabels: [
                        openj9:  'hw.arch.ppc64le && (sw.os.cent.7 || sw.os.rhel.7)'
                ],
                configureArgs       : [
                        "openj9"      : '--enable-dtrace=auto --enable-jitserver --with-vendor-name="IBM Corporation" --with-vendor-version-string="11.0.12.0-IBM" --with-vendor-url=https://www.ibm.com/ --with-vendor-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-vendor-vm-bug-url=https://www.ibm.com/support/pages/java-sdk-support --with-jdk-rc-name="IBM Java Platform"'
                ],
                additionalFileNameTag: "IBM",
                buildArgs : "--ssh --disable-adopt-branch-safety -r git@github.ibm.com:runtimes/openj9-openjdk-jdk11 -b ibm-v0.27.0-release"

        ],

        aarch64Linux    : [
                os                  : 'linux',
                arch                : 'aarch64',
                dockerImage         : 'adoptopenjdk/centos7_build_image',
                dockerNode         : 'sw.tool.docker',
                dockerCredential    : '9f50c848-8764-440d-b95a-1d295c21713e',
                additionalNodeLabels: [
                        openj9:  'hw.arch.aarch64 && sw.os.linux'
                ],
                test                : 'default',
                configureArgs       : [
                        "hotspot" : '--enable-dtrace=auto',
                        "openj9" : '--enable-dtrace=auto',
                        "corretto" : '--enable-dtrace=auto',
                        "dragonwell" : "--enable-dtrace=auto --with-extra-cflags=\"-march=armv8.2-a+crypto\" --with-extra-cxxflags=\"-march=armv8.2-a+crypto\"",
                        "bisheng" : '--enable-dtrace=auto --with-extra-cflags=-fstack-protector-strong --with-extra-cxxflags=-fstack-protector-strong --with-jvm-variants=server'
                ]
        ]
  ]

}

Config11 config = new Config11()
return config.buildConfigurations
