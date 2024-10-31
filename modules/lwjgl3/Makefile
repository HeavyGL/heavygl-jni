JAVA_SRC_DIR = src/main/java/org/josl/heavygl
C_SRC_DIR = src/main/c
GENERATED_C_CODE = src/generated/c

PROJ_ROOT = ../..
TOOLS_DIR = $(PROJ_ROOT)/bin/tools
BUILD_DLL_DIR = $(PROJ_ROOT)/bin/dll

# Modify these if necessary
gcc64 = $(TOOLS_DIR)/mingw64/bin/gcc
gcc32 = gcc

# Generate headers
generate-headers: $(JAVA_SRC_DIR)/HGL10C.java
	@echo : Generating headers for `HGL10C.java'...
	@javac -h $(GENERATED_C_CODE) $(JAVA_SRC_DIR)/HGL10C.java
	@echo : Done!

# For windows
build-dll: $(C_SRC_DIR)/org_josl_heavygl_HGL10C.c
	@echo : Generating 64-bits DLL file...
	@"$(gcc64)" -shared -o $(BUILD_DLL_DIR)/heavygl.dll -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/win32" $(C_SRC_DIR)/*.c
	@rem echo : Generating 32-bits DLL file...
	@rem "$(gcc32)" -shared -o $(BUILD_DLL_DIR)/heavygl32.dll -I"${JAVA_HOME}/include" -I"${JAVA_HOME}/include/win32" $(C_SRC_DIR)/*.c
	@echo : Done!
