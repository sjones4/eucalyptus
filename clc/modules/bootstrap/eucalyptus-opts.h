/** @file eucalyptus-opts.h
 *  @brief The header file for the command line option parser
 *  generated by GNU Gengetopt version 2.22.1
 *  http://www.gnu.org/software/gengetopt.
 *  DO NOT modify this file, since it can be overwritten
 *  @author GNU Gengetopt by Lorenzo Bettini */

#ifndef EUCALYPTUS_OPTS_H
#define EUCALYPTUS_OPTS_H

/* If we use autoconf.  */
#ifdef HAVE_CONFIG_H
#include "config.h"
#endif

#include <stdio.h> /* for FILE */

#ifdef __cplusplus
extern "C" {
#endif /* __cplusplus */

#ifndef ARGUMENTS_PACKAGE
/** @brief the program name */
#define ARGUMENTS_PACKAGE "Eucalyptus"
#endif

#ifndef ARGUMENTS_VERSION
/** @brief the program version */
#define ARGUMENTS_VERSION "v1.6"
#endif

/** @brief Where the command line options are stored */
struct eucalyptus_opts
{
  const char *help_help; /**< @brief Print help and exit help description.  */
  const char *full_help_help; /**< @brief Print help, including hidden options, and exit help description.  */
  const char *version_help; /**< @brief Print version and exit help description.  */
  char * user_arg;	/**< @brief User to drop privs to after starting. (default='eucalyptus').  */
  char * user_orig;	/**< @brief User to drop privs to after starting. original value given at command line.  */
  const char *user_help; /**< @brief User to drop privs to after starting. help description.  */
  char * home_arg;	/**< @brief Eucalyptus home directory. (default='/').  */
  char * home_orig;	/**< @brief Eucalyptus home directory. original value given at command line.  */
  const char *home_help; /**< @brief Eucalyptus home directory. help description.  */
  char * cloud_host_arg;	/**< @brief Hostname/Address for the Cloud Controller. (default='127.0.0.1').  */
  char * cloud_host_orig;	/**< @brief Hostname/Address for the Cloud Controller. original value given at command line.  */
  const char *cloud_host_help; /**< @brief Hostname/Address for the Cloud Controller. help description.  */
  char * walrus_host_arg;	/**< @brief Hostname/Address for Walrus. (default='localhost').  */
  char * walrus_host_orig;	/**< @brief Hostname/Address for Walrus. original value given at command line.  */
  const char *walrus_host_help; /**< @brief Hostname/Address for Walrus. help description.  */
  char ** define_arg;	/**< @brief Set system properties..  */
  char ** define_orig;	/**< @brief Set system properties. original value given at command line.  */
  unsigned int define_min; /**< @brief Set system properties.'s minimum occurreces */
  unsigned int define_max; /**< @brief Set system properties.'s maximum occurreces */
  const char *define_help; /**< @brief Set system properties. help description.  */
  int verbose_flag;	/**< @brief Verbose bootstrapper output. Note: This only controls the level of output from the native bootstrapper. (default=off).  */
  const char *verbose_help; /**< @brief Verbose bootstrapper output. Note: This only controls the level of output from the native bootstrapper. help description.  */
  char * log_level_arg;	/**< @brief Control the log level for console output. (default='INFO').  */
  char * log_level_orig;	/**< @brief Control the log level for console output. original value given at command line.  */
  const char *log_level_help; /**< @brief Control the log level for console output. help description.  */
  char * out_arg;	/**< @brief Redirect standard out to file. (default='&1').  */
  char * out_orig;	/**< @brief Redirect standard out to file. original value given at command line.  */
  const char *out_help; /**< @brief Redirect standard out to file. help description.  */
  char * err_arg;	/**< @brief Redirect standard error to file. (default='&2').  */
  char * err_orig;	/**< @brief Redirect standard error to file. original value given at command line.  */
  const char *err_help; /**< @brief Redirect standard error to file. help description.  */
  int remote_cloud_flag;	/**< @brief Do not try to bootstrap cloud services locally. (default=off).  */
  const char *remote_cloud_help; /**< @brief Do not try to bootstrap cloud services locally. help description.  */
  int remote_walrus_flag;	/**< @brief Do not try to bootstrap walrus services locally. (default=off).  */
  const char *remote_walrus_help; /**< @brief Do not try to bootstrap walrus services locally. help description.  */
  int remote_dns_flag;	/**< @brief Do not try to bootstrap DNS locally. (default=off).  */
  const char *remote_dns_help; /**< @brief Do not try to bootstrap DNS locally. help description.  */
  int remote_storage_flag;	/**< @brief Do not try to bootstrap storage locally. (default=off).  */
  const char *remote_storage_help; /**< @brief Do not try to bootstrap storage locally. help description.  */
  int disable_cloud_flag;	/**< @brief Disable loading cloud services altogether. (default=off).  */
  const char *disable_cloud_help; /**< @brief Disable loading cloud services altogether. help description.  */
  int disable_walrus_flag;	/**< @brief Disable loading walrus services altogether. (default=off).  */
  const char *disable_walrus_help; /**< @brief Disable loading walrus services altogether. help description.  */
  int disable_dns_flag;	/**< @brief Disable loading DNS services altogether. (default=off).  */
  const char *disable_dns_help; /**< @brief Disable loading DNS services altogether. help description.  */
  int disable_storage_flag;	/**< @brief Disable loading storage services altogether. (default=off).  */
  const char *disable_storage_help; /**< @brief Disable loading storage services altogether. help description.  */
  int check_flag;	/**< @brief Check on Eucalyptus. (default=off).  */
  const char *check_help; /**< @brief Check on Eucalyptus. help description.  */
  int stop_flag;	/**< @brief Stop Eucalyptus. (default=off).  */
  const char *stop_help; /**< @brief Stop Eucalyptus. help description.  */
  int fork_flag;	/**< @brief Fork and daemonize Eucalyptus. (default=off).  */
  const char *fork_help; /**< @brief Fork and daemonize Eucalyptus. help description.  */
  char * pidfile_arg;	/**< @brief Location for the pidfile. (default='/var/run/eucalyptus-cloud.pid').  */
  char * pidfile_orig;	/**< @brief Location for the pidfile. original value given at command line.  */
  const char *pidfile_help; /**< @brief Location for the pidfile. help description.  */
  char * java_home_arg;	/**< @brief Alternative way to specify JAVA_HOME. (default='/usr/lib/jvm/java-6-openjdk').  */
  char * java_home_orig;	/**< @brief Alternative way to specify JAVA_HOME. original value given at command line.  */
  const char *java_home_help; /**< @brief Alternative way to specify JAVA_HOME. help description.  */
  char * jvm_name_arg;	/**< @brief Which JVM type to run (see jvm.cfg). (default='-server').  */
  char * jvm_name_orig;	/**< @brief Which JVM type to run (see jvm.cfg). original value given at command line.  */
  const char *jvm_name_help; /**< @brief Which JVM type to run (see jvm.cfg). help description.  */
  char ** jvm_args_arg;	/**< @brief Arguments to pass to the JVM..  */
  char ** jvm_args_orig;	/**< @brief Arguments to pass to the JVM. original value given at command line.  */
  unsigned int jvm_args_min; /**< @brief Arguments to pass to the JVM.'s minimum occurreces */
  unsigned int jvm_args_max; /**< @brief Arguments to pass to the JVM.'s maximum occurreces */
  const char *jvm_args_help; /**< @brief Arguments to pass to the JVM. help description.  */
  int debug_flag;	/**< @brief Launch with debugger enabled. (default=off).  */
  const char *debug_help; /**< @brief Launch with debugger enabled. help description.  */
  int debug_port_arg;	/**< @brief Set the port to use for the debugger. (default='5005').  */
  char * debug_port_orig;	/**< @brief Set the port to use for the debugger. original value given at command line.  */
  const char *debug_port_help; /**< @brief Set the port to use for the debugger. help description.  */
  int debug_suspend_flag;	/**< @brief Set the port to use for the debugger. (default=off).  */
  const char *debug_suspend_help; /**< @brief Set the port to use for the debugger. help description.  */
  int profile_flag;	/**< @brief Launch with jprofiler enabled. (default=off).  */
  const char *profile_help; /**< @brief Launch with jprofiler enabled. help description.  */
  char * profiler_home_arg;	/**< @brief Set the home for jprofiler. (default='/opt/jprofiler5').  */
  char * profiler_home_orig;	/**< @brief Set the home for jprofiler. original value given at command line.  */
  const char *profiler_home_help; /**< @brief Set the home for jprofiler. help description.  */
  
  unsigned int help_given ;	/**< @brief Whether help was given.  */
  unsigned int full_help_given ;	/**< @brief Whether full-help was given.  */
  unsigned int version_given ;	/**< @brief Whether version was given.  */
  unsigned int user_given ;	/**< @brief Whether user was given.  */
  unsigned int home_given ;	/**< @brief Whether home was given.  */
  unsigned int cloud_host_given ;	/**< @brief Whether cloud-host was given.  */
  unsigned int walrus_host_given ;	/**< @brief Whether walrus-host was given.  */
  unsigned int define_given ;	/**< @brief Whether define was given.  */
  unsigned int verbose_given ;	/**< @brief Whether verbose was given.  */
  unsigned int log_level_given ;	/**< @brief Whether log-level was given.  */
  unsigned int out_given ;	/**< @brief Whether out was given.  */
  unsigned int err_given ;	/**< @brief Whether err was given.  */
  unsigned int remote_cloud_given ;	/**< @brief Whether remote-cloud was given.  */
  unsigned int remote_walrus_given ;	/**< @brief Whether remote-walrus was given.  */
  unsigned int remote_dns_given ;	/**< @brief Whether remote-dns was given.  */
  unsigned int remote_storage_given ;	/**< @brief Whether remote-storage was given.  */
  unsigned int disable_cloud_given ;	/**< @brief Whether disable-cloud was given.  */
  unsigned int disable_walrus_given ;	/**< @brief Whether disable-walrus was given.  */
  unsigned int disable_dns_given ;	/**< @brief Whether disable-dns was given.  */
  unsigned int disable_storage_given ;	/**< @brief Whether disable-storage was given.  */
  unsigned int check_given ;	/**< @brief Whether check was given.  */
  unsigned int stop_given ;	/**< @brief Whether stop was given.  */
  unsigned int fork_given ;	/**< @brief Whether fork was given.  */
  unsigned int pidfile_given ;	/**< @brief Whether pidfile was given.  */
  unsigned int java_home_given ;	/**< @brief Whether java-home was given.  */
  unsigned int jvm_name_given ;	/**< @brief Whether jvm-name was given.  */
  unsigned int jvm_args_given ;	/**< @brief Whether jvm-args was given.  */
  unsigned int debug_given ;	/**< @brief Whether debug was given.  */
  unsigned int debug_port_given ;	/**< @brief Whether debug-port was given.  */
  unsigned int debug_suspend_given ;	/**< @brief Whether debug-suspend was given.  */
  unsigned int profile_given ;	/**< @brief Whether profile was given.  */
  unsigned int profiler_home_given ;	/**< @brief Whether profiler-home was given.  */

} ;

/** @brief The additional parameters to pass to parser functions */
struct arguments_params
{
  int override; /**< @brief whether to override possibly already present options (default 0) */
  int initialize; /**< @brief whether to initialize the option structure eucalyptus_opts (default 1) */
  int check_required; /**< @brief whether to check that all required options were provided (default 1) */
  int check_ambiguity; /**< @brief whether to check for options already specified in the option structure eucalyptus_opts (default 0) */
  int print_errors; /**< @brief whether getopt_long should print an error message for a bad option (default 1) */
} ;

/** @brief the purpose string of the program */
extern const char *eucalyptus_opts_purpose;
/** @brief the usage string of the program */
extern const char *eucalyptus_opts_usage;
/** @brief all the lines making the help output */
extern const char *eucalyptus_opts_help[];
/** @brief all the lines making the full help output (including hidden options) */
extern const char *eucalyptus_opts_full_help[];

/**
 * The command line parser
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments (int argc, char * const *argv,
  struct eucalyptus_opts *args_info);

/**
 * The command line parser (version with additional parameters - deprecated)
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @param override whether to override possibly already present options
 * @param initialize whether to initialize the option structure my_args_info
 * @param check_required whether to check that all required options were provided
 * @return 0 if everything went fine, NON 0 if an error took place
 * @deprecated use arguments_ext() instead
 */
int arguments2 (int argc, char * const *argv,
  struct eucalyptus_opts *args_info,
  int override, int initialize, int check_required);

/**
 * The command line parser (version with additional parameters)
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @param params additional parameters for the parser
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_ext (int argc, char * const *argv,
  struct eucalyptus_opts *args_info,
  struct arguments_params *params);

/**
 * Save the contents of the option struct into an already open FILE stream.
 * @param outfile the stream where to dump options
 * @param args_info the option struct to dump
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_dump(FILE *outfile,
  struct eucalyptus_opts *args_info);

/**
 * Save the contents of the option struct into a (text) file.
 * This file can be read by the config file parser (if generated by gengetopt)
 * @param filename the file where to save
 * @param args_info the option struct to save
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_file_save(const char *filename,
  struct eucalyptus_opts *args_info);

/**
 * Print the help
 */
void arguments_print_help(void);
/**
 * Print the full help (including hidden options)
 */
void arguments_print_full_help(void);
/**
 * Print the version
 */
void arguments_print_version(void);

/**
 * Initializes all the fields a arguments_params structure 
 * to their default values
 * @param params the structure to initialize
 */
void arguments_params_init(struct arguments_params *params);

/**
 * Allocates dynamically a arguments_params structure and initializes
 * all its fields to their default values
 * @return the created and initialized arguments_params structure
 */
struct arguments_params *arguments_params_create(void);

/**
 * Initializes the passed eucalyptus_opts structure's fields
 * (also set default values for options that have a default)
 * @param args_info the structure to initialize
 */
void arguments_init (struct eucalyptus_opts *args_info);
/**
 * Deallocates the string fields of the eucalyptus_opts structure
 * (but does not deallocate the structure itself)
 * @param args_info the structure to deallocate
 */
void arguments_free (struct eucalyptus_opts *args_info);

/**
 * Checks that all the required options were specified
 * @param args_info the structure to check
 * @param prog_name the name of the program that will be used to print
 *   possible errors
 * @return
 */
int arguments_required (struct eucalyptus_opts *args_info,
  const char *prog_name);


#ifdef __cplusplus
}
#endif /* __cplusplus */
#endif /* EUCALYPTUS_OPTS_H */
